package com.javacadabra.clinica.modelo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@MappedSuperclass
public class EntidadConNombre extends EntidadBase {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "nombre")
	private String nombre;	
	
	@Override
	public String toString() {
		return this.getNombre();
	}
}
