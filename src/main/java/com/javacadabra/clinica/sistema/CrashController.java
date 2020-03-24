package com.javacadabra.clinica.sistema;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador usado para mostrar lo que pasa cuando se lanza una excepción
 *
 * Also see how a view that resolves to "error" has been added ("error.html").
 */
@Controller
class CrashController {

	@GetMapping("/oups")
	public String triggerException() {
		throw new RuntimeException(
				"Esperada: controlador usado para mostrar lo que pasa cuando se lanza una excepción");
	}

}
