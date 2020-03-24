package com.javacadabra.clinica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacadabra.clinica.modelo.Propietario;

/**
 * Repositorio para objetos de dominio <code>Propietario</code>.
 * 
 * @author Vicente Priego
 */
@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {

	List<Propietario> findByApellidosStartingWith(String apellidos);

}
