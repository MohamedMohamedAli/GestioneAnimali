package it.gestioneCavalli.dao;

import java.util.List;

import it.gestioneCavalli.dto.FerraturaDTO;
import it.gestioneCavalli.model.Ferratura;

public interface FerraturaDAO extends IBaseDAO<Ferratura>{

	List<Ferratura> findByExample(FerraturaDTO input);
	
	List<Ferratura> listAllWithId(Long id);
	
	List<Ferratura> getWithDateFerratura(String dataDa, String dataA);

	void deleteByCavallo(Long id);

	List<Ferratura> getAllPrenotati();

	Ferratura getEager(Long id);

	List<Ferratura> findByExamplePrenotati(FerraturaDTO input);
}
