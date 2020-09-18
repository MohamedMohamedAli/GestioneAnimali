package it.gestioneCavalli.dao;

import java.util.List;

import it.gestioneCavalli.dto.VaccinoDTO;
import it.gestioneCavalli.model.Vaccino;

public interface VaccinoDAO extends IBaseDAO<Vaccino> {

	List<Vaccino> listAllWithId(Long id);

	List<Vaccino> findWithExample(VaccinoDTO input);
}
