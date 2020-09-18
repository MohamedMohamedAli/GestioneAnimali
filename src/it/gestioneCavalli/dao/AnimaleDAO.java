package it.gestioneCavalli.dao;

import java.util.List;

import it.gestioneCavalli.dto.CavalloDTO;
import it.gestioneCavalli.model.Animale;

public interface AnimaleDAO extends IBaseDAO<Animale>{

	List<Animale> findByExampleDTO(CavalloDTO input);
	
}
