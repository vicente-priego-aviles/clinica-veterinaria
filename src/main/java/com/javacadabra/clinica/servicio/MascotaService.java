package com.javacadabra.clinica.servicio;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacadabra.clinica.modelo.Mascota;
import com.javacadabra.clinica.repositorio.MascotaRepository;

/**
 * Servicio para objetos de dominio <code>Mascota</code>.
 * 
 * @author Vicente Priego
 */
@Service
public class MascotaService {
	
	private final MascotaRepository mascotaRepository;

	public MascotaService(MascotaRepository mascotaRepository) {
		this.mascotaRepository = mascotaRepository;
	}
	
	/**
	 * Recupera un {@link Optional} de {@link Mascota} del almacén de datos por id.
	 * @param Intefger id El id que buscar
	 * @return Optional<Mascota> Un {@link Optional} de {@link Mascota}
	 */
	@Transactional(readOnly = true)
	public Optional<Mascota> findById(Integer id) throws DataAccessException {
		return mascotaRepository.findById(id);
	}
	
	/**
	 * Guarda una {@link Mascota} en almacén de datos, insertándola o actualizándola.
	 * @param {@link Mascota} La Mascota guardada o actualizada
	 */
	@Transactional
	public Mascota save(Mascota mascota) throws DataAccessException {
		return mascotaRepository.save(mascota);
	}

}
