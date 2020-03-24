package com.javacadabra.clinica.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto de dominio que represesta a una mascota.
 *
 * @author Vicente Priego
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "mascota")
public class Mascota extends EntidadConNombre {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private TipoMascota tipo;
	
	@Column(name = "fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "propietario_id")
	private Propietario propietario;

	@Transient
	private Set<Visita> visitas = new LinkedHashSet<>();
	
	protected Set<Visita> obtenerVisitasInterno() {
		if (this.visitas == null) {
			this.visitas = new HashSet<>();
		}
		return this.visitas;
	}

	public void establecerVisitasInterno(Collection<Visita> visitas) {
		this.visitas = new LinkedHashSet<>(visitas);
	}

	/**
	 * Devuelve las <code>Visita<code>s de la Mascota.
	 * @return List<Visita> lista ordenada e inmodificable de Mascotas
	 */
	public List<Visita> getVisitas() {
		List<Visita> sortedVisitas = new ArrayList<>(obtenerVisitasInterno());
		PropertyComparator.sort(sortedVisitas, new MutableSortDefinition("date", false, false));
		return Collections.unmodifiableList(sortedVisitas);
	}

	/**
	 * Añade una <code>Visita<code> a la Mascota.
	 */
	public void añadirVisita(Visita visita) {
		obtenerVisitasInterno().add(visita);
		visita.setMascotaId(this.getId());
	}

}
