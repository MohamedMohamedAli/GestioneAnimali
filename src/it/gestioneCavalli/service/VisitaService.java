package it.gestioneCavalli.service;

import java.util.List;

import it.gestioneCavalli.dto.VisitaDTO;
import it.gestioneCavalli.model.Visita;

public interface VisitaService extends IBaseService<Visita>{

	List<Visita> cercaByExample(VisitaDTO input);
	
	List<Visita> listaConIdCavallo(Long id);
	
	List<Visita> caricaCavalliConDataVisita(String dataDa, String dataA);

}
