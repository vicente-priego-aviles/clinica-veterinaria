package com.javacadabra.clinica.utilidades;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.javacadabra.clinica.modelo.TipoMascota;
import com.javacadabra.clinica.servicio.TipoMascotaService;


/**
 * Instructs Spring MVC on how to parse and print elements of type 'TipoMascota'. Starting
 * from Spring 3.0, Formatters have come as an improvement in comparison to legacy
 * PropertyEditors. See the following links for more details: - The Spring ref doc:
 * https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#format
 *
 * @author Vicente Priego
 */
@Component
public class TipoMascotaFormatter implements Formatter<TipoMascota> {
	
	private final TipoMascotaService tipoMascotaService ;

	@Autowired
	public TipoMascotaFormatter(TipoMascotaService tipoMascotaService ) {
		this.tipoMascotaService = tipoMascotaService;
	}

	@Override
	public String print(TipoMascota tipoMascota , Locale locale) {
		return tipoMascota.getNombre();
	}

	@Override
	public TipoMascota parse(String texto, Locale locale) throws ParseException {
		List<TipoMascota> findTipoMascotas = this.tipoMascotaService.findAll();
		for (TipoMascota tipo : findTipoMascotas) {
			if (tipo.getNombre().equals(texto)) {
				return tipo;
			}
		}
		throw new ParseException("tipo de mascota no encontrado: " + texto, 0);
	}

}
