package com.javacadabra.clinica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacadabra.clinica.modelo.Visita;

/**
 * Repositorio para objetos de dominio <code>Visita</code>.
 * 
 * @author Vicente Priego
 */
@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {
	
	List<Visita> findByMascotaId(Integer mascotaId);
}
