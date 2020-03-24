package com.javacadabra.clinica.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javacadabra.clinica.modelo.Veterinario;
import com.javacadabra.clinica.servicio.VeterinarioService;

@Controller
public class VeterinarioController {

	private final VeterinarioService veterinarioService;

	public VeterinarioController(VeterinarioService veterinarioService) {
		this.veterinarioService = veterinarioService;
	}
	
	@GetMapping("/veterinarios.html")
	public String mostrarListaVeterinarios(Map<String, Object> model) {
		List<Veterinario> veterinarios = this.veterinarioService.findAll();
		model.put("veterinarios", veterinarios);
		return "veterinarios/veterinarioLista";
	}

	@GetMapping({ "/veterinarios.json" })
	public @ResponseBody List<Veterinario> mostrarListaRecursoVeterinarios() {
		return this.veterinarioService.findAll();
	}

}