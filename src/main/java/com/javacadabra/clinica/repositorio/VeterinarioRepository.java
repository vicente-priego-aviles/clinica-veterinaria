package com.javacadabra.clinica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacadabra.clinica.modelo.Veterinario;

/**
 * Repository de objetos de dominio <code>Veterinario</code>.
 */
@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {	
}
