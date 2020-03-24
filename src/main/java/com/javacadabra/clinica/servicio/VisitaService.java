package com.javacadabra.clinica.servicio;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacadabra.clinica.modelo.Propietario;
import com.javacadabra.clinica.modelo.Visita;
import com.javacadabra.clinica.repositorio.VisitaRepository;

/**
 * Servicio para objetos de dominio <code>Visita</code>.
 * 
 * @author Vicente Priego
 */
@Service
public class VisitaService {
	
	private final VisitaRepository visitaRepository;

	public VisitaService(VisitaRepository visitaRepository) {
		this.visitaRepository = visitaRepository;
	}

	/**
	 * Recupera todos las <code>Visitas</code>s de una mascota del almacén de datos.
	 * @return List<Visita> una <code>List</code> de <code>Visita</code>s
	 */
	@Transactional(readOnly = true)
	public List<Visita> findByMascotaId(Integer mascotaId){
		return visitaRepository.findByMascotaId(mascotaId);
	}
	
	/**
	 * Guarda una {@link Visita} en el almacén de datos, insertándolo o actualizándolo.
	 * @param propietario el {@link Propietario} que guardar
	 * @return {@link Visita} La visita guardada o actualizada
	 */
	@Transactional
	public Visita save(Visita visita) throws DataAccessException{
		return visitaRepository.save(visita);
	}

}
