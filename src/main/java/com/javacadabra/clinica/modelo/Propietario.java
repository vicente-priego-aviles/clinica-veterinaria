package com.javacadabra.clinica.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto de dominio que represesta a un propietario mde mascotas.
 *
 * @author Vicente Priego
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "propietario")
public class Propietario extends Persona {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore // para evitar un bucle infinito que provaca un Stack Overflow
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "propietario")
	private Set<Mascota> mascotas;
	
	protected Set<Mascota> obtenerMascotasInterno() {
		if (this.mascotas == null) {
			this.mascotas = new HashSet<>();
		}
		return this.mascotas;
	}
	
	public void añadirMascota(Mascota mascota) {
		if (mascota.isNueva()) {
			obtenerMascotasInterno().add(mascota);
		}
		mascota.setPropietario(this);
	}
	
	/**
	 * Devuelve la Mascota con ese nombre, o null si no se encuentra ninguna para ese Propietario.
	 * @param nombre a probar
	 * @return true si el nombre de la mascota ya está en uso
	 */
	public Mascota getMascota(String nombre) {
		return getMascota(nombre, false);
	}

	/**
	 * Devuelve la Mascota con ese nombre, o null si no se encuentra ninguna para ese Propietario.
	 * @param nombre a probar
	 * @param ignorarNuevo si debe ignorarse un nombre nuevo
	 * @return true si el nombre de la mascota ya está en uso
	 */
	public Mascota getMascota(String nombre, boolean ignorarNuevo) {
		nombre = nombre.toLowerCase();
		for (Mascota mascota : obtenerMascotasInterno()) {
			if (!ignorarNuevo || !mascota.isNueva()) {
				String compName = mascota.getNombre();
				compName = compName.toLowerCase();
				if (compName.equals(nombre)) {
					return mascota;
				}
			}
		}
		return null;
	}

}
