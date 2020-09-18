package it.gestioneCavalli.service;

import java.util.List;

import it.gestioneCavalli.dto.FerraturaDTO;
import it.gestioneCavalli.model.Ferratura;

public interface FerraturaService extends IBaseService<Ferratura> {

	List<Ferratura> cercaByExample(FerraturaDTO input);

	List<Ferratura> listaConIdCavallo(Long id);

	List<Ferratura> caricaCavalliConDataFerratura(String dataDa, String dataA);
	
	List<Ferratura> caricaPrenotati();

	Ferratura caricaEager(Long id);

	List<Ferratura> cercaByExamplePrenotate(FerraturaDTO input);

}
