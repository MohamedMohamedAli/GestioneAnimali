package it.gestioneCavalli.dao;

import java.util.List;

import it.gestioneCavalli.dto.VisitaDTO;
import it.gestioneCavalli.model.Visita;

public interface VisitaDAO extends IBaseDAO<Visita>{

	List<Visita> findByExample(VisitaDTO input);
	
	List<Visita> listAllWithId(Long id);
	
	List<Visita> getWithDateVisita(String dataDa, String dataA);

}
