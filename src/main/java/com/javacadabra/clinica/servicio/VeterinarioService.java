package com.javacadabra.clinica.servicio;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacadabra.clinica.modelo.Veterinario;
import com.javacadabra.clinica.repositorio.VeterinarioRepository;

/**
 * Servicio para objetos de dominio <code>Veterinario</code>.
 * 
 * @author Vicente Priego
 */
@Service
public class VeterinarioService {

	private final VeterinarioRepository veterinarioRepository;
	
	public VeterinarioService(VeterinarioRepository veterinarioRepository) {
		this.veterinarioRepository = veterinarioRepository;
	}

	/**
	 * Recupera todos los <code>Veterinario</code>s del almacén de datos.
	 * @return List<Veterinario> una <code>List</code> de <code>Veterinario</code>s
	 */
	@Transactional(readOnly = true)
	@Cacheable("veterinarios")
	public List<Veterinario> findAll() throws DataAccessException {
		return veterinarioRepository.findAll();
	}

}
