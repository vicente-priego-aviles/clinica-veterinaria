package com.javacadabra.clinica.controlador;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javacadabra.clinica.modelo.Mascota;
import com.javacadabra.clinica.modelo.Propietario;
import com.javacadabra.clinica.servicio.PropietarioService;
import com.javacadabra.clinica.servicio.VisitaService;

@Controller
public class PropietarioController {
	
	private static final String VISTAS_FORMULARIO_CREAR_ACTUALIZAR_PROPIETARIO = "propietarios/formularioCrearOActualizarPropietario";

	private final PropietarioService propietarioService;
	private final VisitaService visitaService;

	public PropietarioController(PropietarioService propietarioService, VisitaService visitaService) {
		this.propietarioService = propietarioService;
		this.visitaService = visitaService;
	}
	
	//TODO revisar
	@InitBinder
	public void establecerCamposPermitidos(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping("/propietarios/nuevo")
	public String iniciarFormularioCreaccion(Map<String, Object> model) {
		Propietario propietario = new Propietario();
		model.put("propietario", propietario);
		return VISTAS_FORMULARIO_CREAR_ACTUALIZAR_PROPIETARIO;
	}

	@PostMapping("/propietarios/nuevo")
	public String processCreationForm(@Valid Propietario propietario, BindingResult result) {
		if (result.hasErrors()) {
			return VISTAS_FORMULARIO_CREAR_ACTUALIZAR_PROPIETARIO;
		}
		else {
			this.propietarioService.save(propietario);
			return "redirect:/propietarios/" + propietario.getId();
		}
	}

	@GetMapping("/propietarios/buscar")
	public String iniciarFormularioBuscar(Map<String, Object> model) {
		model.put("propietario", new Propietario());
		return "propietarios/buscarPropietarios";
	}

	@GetMapping("/propietarios")
	public String procesarFormularioBuscar(Propietario propietario, BindingResult result, Map<String, Object> model) {

		// permite una petición GET sin parámetros a /propietarios devolver todos los registros
		if (propietario.getApellidos() == null) {
			propietario.setApellidos(""); // una cadena vacía represanta la búsqueda más amplia posible
		}

		// busca propietarios por apellidos
		List<Propietario> propietarios = this.propietarioService.findByApellidos(propietario.getApellidos());
		if (propietarios.isEmpty()) {
			// no se han encontrado propietarios
			// TODO cambiar mensaje a español
			result.rejectValue("apellidos", "notEncontrado", "no encontrado");
			return "propietarios/buscarPropietarios";
		}
		else if (propietarios.size() == 1) {
			// 1 propietario encontrado
			propietario = propietarios.iterator().next();
			return "redirect:/propietarios/" + propietario.getId();
		}
		else {
			// varios propietarios encontrados
			model.put("propietarios", propietarios);
			return "propietarios/propietariosLista";
		}
	}
	
	@GetMapping("/propietarios/{propietarioId}/editar")
	public String iniciarFormularioActualizar(@PathVariable("propietarioId") int propietarioId, Model model) {
		// TODO revisar este optional
		Propietario propietario = this.propietarioService.findById(propietarioId).get();
		model.addAttribute(propietario);
		return VISTAS_FORMULARIO_CREAR_ACTUALIZAR_PROPIETARIO;
	}

	@PostMapping("/propietarios/{propietarioId}/editar")
	public String procesarFormularioActualizar(@Valid Propietario propietario, BindingResult result,
			@PathVariable("propietarioId") int propietarioId) {
		if (result.hasErrors()) {
			return VISTAS_FORMULARIO_CREAR_ACTUALIZAR_PROPIETARIO;
		}
		else {
			propietario.setId(propietarioId);
			this.propietarioService.save(propietario);
			return "redirect:/propietarios/{propietarioId}";
		}
	}

	/**
	 * Manejador personalizado para mostar un propietario.
	 * @param int propietarioId El ID del propietario a mostar
	 * @return a ModelMap con el modelo de atributos para la vista
	 */
	@GetMapping("/propietarios/{propietarioId}")
	// TODO tratar el optional
	public ModelAndView mostrarPropietario(@PathVariable("propietarioId") int propietarioId) {
		ModelAndView modelAndView = new ModelAndView("propietarios/propietarioDetalles");
		Propietario propietario = this.propietarioService.findById(propietarioId).get();
		for (Mascota mascota : propietario.getMascotas()) {
			//TODO ver utililidad de establecerVisitasInterno
			mascota.establecerVisitasInterno(visitaService.findByMascotaId(mascota.getId()));
		}
		modelAndView.addObject(propietario);
		return modelAndView;
	}
	
	// TODO tratar optional y generar excepcion personalizada
	@GetMapping("/json/propietarios/{propietarioId}")
	public @ResponseBody Propietario mostrarPropietarioJson(@PathVariable("propietarioId") int propietarioId){
		Optional<Propietario> propietarioOpt = propietarioService.findById(propietarioId);
		if(propietarioOpt.isPresent()) {
			return propietarioService.findById(propietarioId).get();
		}
		return null;
	}

}
