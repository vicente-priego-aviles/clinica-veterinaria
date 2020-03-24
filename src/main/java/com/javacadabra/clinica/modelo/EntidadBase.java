package com.javacadabra.clinica.modelo;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto de dominio con una propiedad id. Se usa como clase base 
 * para objetos que necesitan esta propiedad.
 *
 * @author Vicente Priego
 */
@Getter
@Setter
@ToString
@MappedSuperclass
public class EntidadBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public boolean isNueva() {
		return this.id == null;
	}

}

