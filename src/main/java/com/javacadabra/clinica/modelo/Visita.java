package com.javacadabra.clinica.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Objeto de dominio que represesta a una visita.
 *
 * @author Vicente Priego
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "visita")
public class Visita extends EntidadBase {

	private static final long serialVersionUID = 1L;

	@Column(name = "fecha_visita")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@Column(name = "descripcion")
	@NotEmpty
	private String descripcion;

	@Column(name = "mascota_id")
	private Integer mascotaId;

	/**
	 * Crea una nueva Visita con la fecha actual.
	 */
	public Visita() {
		this.fecha = LocalDate.now();
	}

}
