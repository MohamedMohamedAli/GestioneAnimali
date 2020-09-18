package it.gestioneCavalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestioneCavalli.dao.AlimentazioneDAO;
import it.gestioneCavalli.model.Alimentazione;

@Service
public class AlimentazioneServiceImp implements AlimentazioneService {

	@Autowired
	private AlimentazioneDAO alimentazioneDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Alimentazione> listAll() {
		return alimentazioneDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Alimentazione caricaConId(Long id) {
		return alimentazioneDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Alimentazione input) {
		alimentazioneDAO.update(input);
	}

	@Transactional
	@Override
	public void inserisci(Alimentazione input) {
		alimentazioneDAO.insert(input);
	}

	@Transactional
	@Override
	public void elimina(Long id) {
		alimentazioneDAO.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Alimentazione> listaConIdAnimale(Long id) {
		return alimentazioneDAO.listAllWithId(id);
	}

}
