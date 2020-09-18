package it.gestioneCavalli.service;

import java.util.List;

import it.gestioneCavalli.dto.CavalloDTO;
import it.gestioneCavalli.model.Animale;

public interface CavalloService extends IBaseService<Animale> {

	List<Animale> cercaByExample(CavalloDTO input);
	
}
