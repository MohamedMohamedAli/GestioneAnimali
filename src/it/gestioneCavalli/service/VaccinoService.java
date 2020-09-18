package it.gestioneCavalli.service;

import java.util.List;

import it.gestioneCavalli.dto.VaccinoDTO;
import it.gestioneCavalli.model.Vaccino;

public interface VaccinoService extends IBaseService<Vaccino> {

	List<Vaccino> listaConIdCavallo(Long id);
	
	List<Vaccino> cercaPerExample(VaccinoDTO input);
}
