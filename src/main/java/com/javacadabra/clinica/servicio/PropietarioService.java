package com.javacadabra.clinica.servicio;


import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacadabra.clinica.modelo.Propietario;
import com.javacadabra.clinica.repositorio.PropietarioRepository;

/**
 * Servicio para objetos de dominio <code>Propietario</code>.
 * 
 * @author Vicente Priego
 */
@Service
public class PropietarioService {
	
	private final PropietarioRepository propietarioRepository;

	public PropietarioService(PropietarioRepository propietarioRepository) {
		this.propietarioRepository = propietarioRepository;
	}
	
	/**
	 * Recupera {@link Propietario}s del almacén de datos por apellidos, devolviendo todos los propietarios
	 * cuyos apellidos <i>empiezan</i> con la cadena de búsqueda suministrada.
	 * @param String apellidos valor por el que buscar
	 * @return Collection<Propietario> una Colección de {@link Propietario}s encontrados (o una Collección vacía si no se encuentar ninguno)
	 */
	@Transactional(readOnly = true)
	public List<Propietario> findByApellidos(String apellidos) throws DataAccessException {
		return propietarioRepository.findByApellidosStartingWith(apellidos);
	}

	/**
	 * Recupera un {@link Propietario} del almacén de datos por id.
	 * @param String id el id que buscar
	 * @return Propietario el {@link Propietario} si se ha encontrado
	 */
	@Transactional(readOnly = true)
	public Optional<Propietario> findById(@Param("id") Integer id) throws DataAccessException {
		return propietarioRepository.findById(id);
	}

	/**
	 * Guarda un {@link Propietario} en el almacén de datos , insertándolo o actualizándolo.
	 * @param propietario el {@link Propietario} que guardar
	 * @return Propietario El propietario guardado o actualizado
	 */
	@Transactional
	public Propietario save(Propietario propietario) throws DataAccessException {
		return propietarioRepository.save(propietario);
	}

}
