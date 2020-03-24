package com.javacadabra.clinica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacadabra.clinica.modelo.Mascota;

/**
 * Repositorio para objetos de dominio <code>Mascota</code>.
 * 
 * @author Vicente Priego
 */
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}
