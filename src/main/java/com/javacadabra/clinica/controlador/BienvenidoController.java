package com.javacadabra.clinica.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class BienvenidoController {

	@GetMapping("/")
	public String bienvenido() {
		return "bienvenido";
	}

}
