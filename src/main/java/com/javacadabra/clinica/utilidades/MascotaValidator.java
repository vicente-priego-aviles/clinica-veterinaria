package com.javacadabra.clinica.utilidades;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.javacadabra.clinica.modelo.Mascota;

/**
 * <code>Validator</code> para formularios <code>Mascota</code>.
 * <p>
 * No se usan aquí anotaciones Bean Validation porque es más sencillo 
 * definir esta regla de validación en Java.
 * </p>
 *
 * @author VicentePriego
 */
public class MascotaValidator implements Validator {

	//TODO : ver si funciona con requerido
	private static final String REQUERIDO = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		Mascota mascota = (Mascota) obj;
		String nombre = mascota.getNombre();
		// validación de nombre
		// TODO validacion cadena vacía
		if (!StringUtils.hasLength(nombre)) {
			errors.rejectValue("nombre", REQUERIDO, REQUERIDO);
		}

		// validación de tipo de mascota
		if (mascota.isNueva() && mascota.getTipo() == null) {
			errors.rejectValue("tipo", REQUERIDO, REQUERIDO);
		}

		// validación de fecha de nacimiento
		if (mascota.getFechaNacimiento() == null) {
			errors.rejectValue("fechaNacimiento", REQUERIDO, REQUERIDO);
		}
	}

	/**
	 * Este Validator valida *solo* instancias Mascota
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Mascota.class.isAssignableFrom(clazz);
	}

}
