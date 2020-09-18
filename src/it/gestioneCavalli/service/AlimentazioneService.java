package it.gestioneCavalli.service;

import java.util.List;

import it.gestioneCavalli.model.Alimentazione;

public interface AlimentazioneService extends IBaseService<Alimentazione>{

	List<Alimentazione> listaConIdAnimale(Long id);

}
