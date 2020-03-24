package com.javacadabra.clinica.servicio;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacadabra.clinica.modelo.TipoMascota;
import com.javacadabra.clinica.repositorio.TipoMascotaRepository;

@Service
public class TipoMascotaService {
	
	private final TipoMascotaRepository tipoMascotaRepository;
	
	public TipoMascotaService(TipoMascotaRepository tipoMascotaRepository) {
		this.tipoMascotaRepository = tipoMascotaRepository;
	}
	
	/**
	 * Recupera todos los {@link TipoMascota}s del almacén de datos.
	 * @return List<TipoMascota> Una lista de {@link TipoMascota}s ordenadas por nombre
	 */
	@Transactional(readOnly = true)
	public List<TipoMascota> findAll(){
		Sort.Order ordenacion = Sort.Order.by("nombre").ignoreCase();
		return tipoMascotaRepository.findAll(Sort.by(ordenacion));
	}

}
