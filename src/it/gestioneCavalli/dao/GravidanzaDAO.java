package it.gestioneCavalli.dao;

import java.util.List;

import it.gestioneCavalli.dto.GravidanzaDTO;
import it.gestioneCavalli.model.Gravidanza;

public interface GravidanzaDAO extends IBaseDAO<Gravidanza> {
	List<Gravidanza> findByExampleDTO(GravidanzaDTO gravidanzaDTO);

	List<Gravidanza> findAttiviWithIdCavallo(Long idCavallo);

	List<Gravidanza> listAllWithId(Long id);

	Gravidanza getEager(Long id);
}
