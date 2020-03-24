package com.javacadabra.clinica.controlador;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javacadabra.clinica.modelo.Mascota;
import com.javacadabra.clinica.modelo.Visita;
import com.javacadabra.clinica.servicio.MascotaService;
import com.javacadabra.clinica.servicio.VisitaService;

@Controller
public class VisitaController {
	
	private final VisitaService visitaService;
	private final MascotaService mascotaService;

	public VisitaController(VisitaService visitaService, MascotaService mascotaService) {
		this.visitaService = visitaService;
		this.mascotaService = mascotaService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/**
	 * Se llama antes de cada llamada a un método anotado con @RequestMapping. 
	 * Tiene dos objetivos :
	 * - Siempre tenemos datos actualizados
	 * - Como no usamos un ámbito de sesión (session scope), nos aseguramos de que el objeto Mascota 
	 *   siempre tiene un id (Aunque incluso id no es uno de los campos del formulario)
	 * @param mascotaId
	 * @return Mascota
	 */
	@ModelAttribute("visita")
	public Visita cargarMascotaConVisita(@PathVariable("mascotaId") int mascotaId, Map<String, Object> model) {
		Mascota mascota = this.mascotaService.findById(mascotaId).get();
		mascota.establecerVisitasInterno(this.visitaService.findByMascotaId(mascotaId));
		Visita visita = new Visita();
		mascota.añadirVisita(visita);
		model.put("mascota", mascota);
		return visita;
	}

	// Spring MVC llama al método cargarMascotaConVisita(...) antes de llamar a iniciarFormularioNuevaVisita
	@GetMapping("/propietarios/*/mascotas/{mascotaId}/visitas/nueva")
	public String iniciarFormularioNuevaVisita(@PathVariable("mascotaId") int mascotaId, Map<String, Object> model) {
		return "mascotas/formularioCrearOActualizarVisita";
	}

	// Spring MVC llama al método cargarMascotaConVisita(...) antes de llamar a procesarFormularioNuevaVisita
	@PostMapping("/propietarios/{propietarioId}/mascotas/{mascotaId}/visitas/nueva")
	public String procesarFormularioNuevaVisita(@Valid Visita visita, BindingResult result) {
		if (result.hasErrors()) {
			return "mascotas/formularioCrearOActualizarVisita";
		}
		else {
			this.visitaService.save(visita);
			return "redirect:/propietarios/{propietarioId}";
		}
	}

}
