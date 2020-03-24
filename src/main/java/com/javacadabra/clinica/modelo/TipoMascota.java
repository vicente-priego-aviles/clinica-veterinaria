package com.javacadabra.clinica.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.ToString;

/**
 * Puede ser Perro, Gato, Tortuga
 * 
 * @author Vicente Priego 
 */
@Entity
@Table(name = "tipo")
public class TipoMascota extends EntidadConNombre {

	private static final long serialVersionUID = 1L;
}
