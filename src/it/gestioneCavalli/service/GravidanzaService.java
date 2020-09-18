package it.gestioneCavalli.service;

import java.util.List;

import it.gestioneCavalli.dto.GravidanzaDTO;
import it.gestioneCavalli.model.Gravidanza;

public interface GravidanzaService extends IBaseService<Gravidanza>{
	List<Gravidanza> cercaByExample(GravidanzaDTO input);
	Gravidanza cercaAttiviConIdCavallo(Long id);
	Gravidanza caricaEager(Long id);
}
