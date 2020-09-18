package it.gestioneCavalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestioneCavalli.dao.GravidanzaDAO;
import it.gestioneCavalli.dto.GravidanzaDTO;
import it.gestioneCavalli.model.Gravidanza;

@Service
public class GravidanzaServiceImp implements GravidanzaService {

	@Autowired
	private GravidanzaDAO gravidanzaDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Gravidanza> listAll() {
		return gravidanzaDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Gravidanza caricaConId(Long id) {
		return gravidanzaDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Gravidanza input) {
		gravidanzaDAO.update(input);
	}

	@Transactional
	@Override
	public void inserisci(Gravidanza input) {
		gravidanzaDAO.insert(input);
	}

	@Transactional
	@Override
	public void elimina(Long id) {
		gravidanzaDAO.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Gravidanza> cercaByExample(GravidanzaDTO input) {
		return gravidanzaDAO.findByExampleDTO(input);
	}

	@Transactional(readOnly = true)
	@Override
	public Gravidanza cercaAttiviConIdCavallo(Long id) {
		List<Gravidanza> gravidanze = gravidanzaDAO.findAttiviWithIdCavallo(id);

		if (gravidanze == null || gravidanze.isEmpty()) {
			return new Gravidanza();
		}

		return gravidanze.get(0);
	}

	@Transactional(readOnly = true)
	@Override
	public Gravidanza caricaEager(Long id) {
		return gravidanzaDAO.getEager(id);
	}

}
