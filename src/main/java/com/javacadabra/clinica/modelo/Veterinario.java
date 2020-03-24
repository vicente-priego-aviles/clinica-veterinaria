package com.javacadabra.clinica.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "veterinario")
public class Veterinario extends Persona {

	private static final long serialVersionUID = 1L;
	
	@Getter(AccessLevel.NONE)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	
		name = "veterinario_especialidad", 
		joinColumns = @JoinColumn(name = "veterinario_id"),
		inverseJoinColumns = @JoinColumn(name = "especialidad_id")
	)
	private Set<Especialidad> especialidades;
	
	public Set<Especialidad> obtenerEspecialidadesInterno() {
		if (this.especialidades == null) {
			this.especialidades = new HashSet<>();
		}
		return this.especialidades;
	}
	
	//@XmlElement
	public List<Especialidad> getEspecialidades() {
		List<Especialidad> esecificacionesOrdenadas = new ArrayList<>(this.obtenerEspecialidadesInterno());
		PropertyComparator.sort(esecificacionesOrdenadas, new MutableSortDefinition("nombre", true, true));
		return Collections.unmodifiableList(esecificacionesOrdenadas);
	}

	public int getNumeroEspecialidades() {
		return this.obtenerEspecialidadesInterno().size();
	}

	public void añadirEspecialidad(Especialidad especialidad) {
		this.obtenerEspecialidadesInterno().add(especialidad);
	}

}
