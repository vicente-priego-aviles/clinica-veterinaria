package com.javacadabra.clinica.modelo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Objeto de dominio que represesta a una persona.
 *
 * @author Vicente Priego
 */
@Data
@EqualsAndHashCode(callSuper=false, onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Persona extends EntidadBase {

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Column(name="nif")
	@NotEmpty
	private String nif;
	
	@Column(name="nombre")
	@NotEmpty
	private String nombre;
	

	@Column(name="apellidos")
	@NotEmpty
	private String apellidos;
	
	@Column(name="direccion")
	@NotEmpty
	private String direccion;
	
	@Column(name="cp")
	@NotEmpty
	private String cp;
	
	@Column(name="municipio")
	@NotEmpty
	private String municipio;
	
	@Column(name="provincia")
	@NotEmpty
	private String provincia;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;

}
