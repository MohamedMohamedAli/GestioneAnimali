package it.gestioneCavalli.dao;

import java.util.List;

import it.gestioneCavalli.model.Alimentazione;

public interface AlimentazioneDAO extends IBaseDAO<Alimentazione>{

	List<Alimentazione> listAllWithId(Long id);

}
