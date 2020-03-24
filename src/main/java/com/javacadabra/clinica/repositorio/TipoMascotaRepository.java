package com.javacadabra.clinica.repositorio;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacadabra.clinica.modelo.TipoMascota;

/**
 * Repositorio para objetos de dominio <code>TipoMascota</code>.
 * 
 * @author Vicente Priego
 */
@Repository
public interface TipoMascotaRepository extends JpaRepository<TipoMascota, Integer>{ 
	
	List<TipoMascota> findAll(Sort sort);
	
}
