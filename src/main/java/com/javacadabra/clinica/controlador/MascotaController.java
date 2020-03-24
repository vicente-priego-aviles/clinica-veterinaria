package com.javacadabra.clinica.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javacadabra.clinica.modelo.Mascota;
import com.javacadabra.clinica.modelo.Propietario;
import com.javacadabra.clinica.modelo.TipoMascota;
import com.javacadabra.clinica.servicio.MascotaService;
import com.javacadabra.clinica.servicio.PropietarioService;
import com.javacadabra.clinica.servicio.TipoMascotaService;
import com.javacadabra.clinica.utilidades.MascotaValidator;

@Controller
@RequestMapping("/propietarios/{propietarioId}")
public class MascotaController {

	private static final String VISTAS_FORMULARIO_CREAR_ACTUALIZAR_MASCOTA = "mascotas/formularioCrearOActualizarMascota";

	private final MascotaService mascotaService;
	private final TipoMascotaService tipoMascotaService;
	private final PropietarioService propietarioService;

	public MascotaController(MascotaService mascotaService, TipoMascotaService tipoMascotaService, PropietarioService propietarioService) {
		this.mascotaService = mascotaService;
		this.tipoMascotaService = tipoMascotaService;
		this.propietarioService = propietarioService;
	}

	@ModelAttribute("tipos")
	public List<TipoMascota> cargarTipoMascotas() {
		return this.tipoMascotaService.findAll();
	}

	@ModelAttribute("propietario")
	public Propietario findPropietario(@PathVariable("propietarioId") int propietarioId) {
		// TODO ver el Optional
		return this.propietarioService.findById(propietarioId).get();
	}

	// TODO
	@InitBinder("propietario")
	public void initPropietarioBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	// TODO
	@InitBinder("mascota")
	public void iniciarMascotaBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new MascotaValidator());
	}

	@GetMapping("/mascotas/nueva")
	public String iniciarFormularioCreaccion(Propietario propietario, ModelMap model) {
		Mascota mascota = new Mascota();
		propietario.añadirMascota(mascota);
		model.put("mascota", mascota);
		return VISTAS_FORMULARIO_CREAR_ACTUALIZAR_MASCOTA;
	}

	@PostMapping("/mascotas/nueva")
	public String procesarFormularioCrear(Propietario propietario, @Valid Mascota mascota, 
			BindingResult result, ModelMap model) {
		if (StringUtils.hasLength(mascota.getNombre()) && mascota.isNueva() 
				&& propietario.getMascota(mascota.getNombre(), true) != null) {
			result.rejectValue("nombre", "duplicate", "already exists");
		}
		propietario.añadirMascota(mascota);
		if (result.hasErrors()) {
			model.put("mascota", mascota);
			return VISTAS_FORMULARIO_CREAR_ACTUALIZAR_MASCOTA;
		}
		else {
			this.mascotaService.save(mascota);
			return "redirect:/propietarios/{propietarioId}";
		}
	}

	@GetMapping("/mascotas/{mascotaId}/editar")
	public String iniciarFormularioActualizar(@PathVariable("mascotaId") int mascotaId, ModelMap model) {
		// TODO tratar el optional
		Mascota mascota = this.mascotaService.findById(mascotaId).get();
		model.put("mascota", mascota);
		return VISTAS_FORMULARIO_CREAR_ACTUALIZAR_MASCOTA;
	}

	@PostMapping("/mascotas/{mascotaId}/editar")
	public String procesarFormularioActualizar(@Valid Mascota mascota, Propietario propietario, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			mascota.setPropietario(propietario);
			model.put("mascota", mascota);
			return VISTAS_FORMULARIO_CREAR_ACTUALIZAR_MASCOTA;
		}
		else {
			propietario.añadirMascota(mascota);
			this.mascotaService.save(mascota);
			return "redirect:/propietarios/{propietarioId}";
		}
	}


}
