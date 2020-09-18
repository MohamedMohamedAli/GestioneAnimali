package it.gestioneCavalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestioneCavalli.dao.VisitaDAO;
import it.gestioneCavalli.dto.VisitaDTO;
import it.gestioneCavalli.model.Visita;
import it.gestioneCavalli.utils.Utils;

@Service
public class VisitaServiceImp implements VisitaService {

	@Autowired
	private VisitaDAO visitaDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Visita> listAll() {
		return visitaDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Visita caricaConId(Long id) {
		return visitaDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Visita input) {
		Visita vis = visitaDAO.get(input.getId());
		vis.setVeterinario(input.getVeterinario());
		vis.setData(input.getData());
		vis.setCausa(input.getCausa());
		vis.setTrattamento(input.getTrattamento());
		vis.setPrezzo(input.getPrezzo());
		vis.setNote(input.getNote());
		vis.setDiagnosi(Utils.getLink("DIAGNOSI" + input.getId(), false));
		visitaDAO.update(vis);
	}

	@Transactional
	@Override
	public void inserisci(Visita input) {
		visitaDAO.insert(input);
		input.setDiagnosi(Utils.getLink("DIAGNOSI" + input.getId(), false));
	}

	@Transactional
	@Override
	public void elimina(Long id) {
		visitaDAO.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Visita> cercaByExample(VisitaDTO input) {
		return visitaDAO.findByExample(input);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Visita> listaConIdCavallo(Long id) {
		return visitaDAO.listAllWithId(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Visita> caricaCavalliConDataVisita(String dataDa, String dataA) {
		return visitaDAO.getWithDateVisita(dataDa, dataA);
	}

}
