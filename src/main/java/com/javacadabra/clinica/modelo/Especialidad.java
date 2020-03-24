package com.javacadabra.clinica.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "especialidad")
public class Especialidad extends EntidadConNombre {

	private static final long serialVersionUID = 1L;

}
