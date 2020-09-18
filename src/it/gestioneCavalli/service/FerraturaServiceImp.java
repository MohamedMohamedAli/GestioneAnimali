package it.gestioneCavalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestioneCavalli.dao.FerraturaDAO;
import it.gestioneCavalli.dto.FerraturaDTO;
import it.gestioneCavalli.model.Ferratura;

@Service
public class FerraturaServiceImp implements FerraturaService {

	@Autowired
	private FerraturaDAO ferraturaDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Ferratura> listAll() {
		return ferraturaDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Ferratura caricaConId(Long id) {
		return ferraturaDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Ferratura input) {
		Ferratura fer = ferraturaDAO.get(input.getId());
		fer.setManiscalco(input.getManiscalco());
		fer.setData(input.getData());
		fer.setTipo(input.getTipo());
		fer.setPrezzo(input.getPrezzo());
		fer.setNote(input.getNote());
		fer.setCompletata(input.isCompletata());
		ferraturaDAO.update(fer);
	}

	@Transactional
	@Override
	public void inserisci(Ferratura input) {
		ferraturaDAO.insert(input);
	}

	@Transactional
	@Override
	public void elimina(Long id) {
		ferraturaDAO.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ferratura> cercaByExample(FerraturaDTO input) {
		return ferraturaDAO.findByExample(input);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ferratura> listaConIdCavallo(Long id) {
		return ferraturaDAO.listAllWithId(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ferratura> caricaCavalliConDataFerratura(String dataDa, String dataA) {
		return ferraturaDAO.getWithDateFerratura(dataDa, dataA);
	}

	@Override
	public List<Ferratura> caricaPrenotati() {
		return ferraturaDAO.getAllPrenotati();
	}

	@Override
	public Ferratura caricaEager(Long id) {
		return ferraturaDAO.getEager(id);
	}

	@Override
	public List<Ferratura> cercaByExamplePrenotate(FerraturaDTO input) {
		return ferraturaDAO.findByExamplePrenotati(input);
	}
}
