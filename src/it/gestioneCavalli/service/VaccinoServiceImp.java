package it.gestioneCavalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestioneCavalli.dao.VaccinoDAO;
import it.gestioneCavalli.dto.VaccinoDTO;
import it.gestioneCavalli.model.Vaccino;

@Service
public class VaccinoServiceImp implements VaccinoService{
	@Autowired
	private VaccinoDAO vaccinoDAO;
	
	@Transactional(readOnly = true)
	@Override
	public List<Vaccino> listAll() {
		return vaccinoDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Vaccino caricaConId(Long id) {
		return vaccinoDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Vaccino input) {
		Vaccino vaccino = vaccinoDAO.get(input.getId());
		vaccino.setTipo(input.getTipo());
		vaccino.setData(input.getData());
		vaccino.setNote(input.getNote());
		vaccinoDAO.update(vaccino);
	}

	@Transactional
	@Override
	public void inserisci(Vaccino input) {
		vaccinoDAO.insert(input);
	}

	@Transactional
	@Override
	public void elimina(Long id) {
		vaccinoDAO.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Vaccino> listaConIdCavallo(Long id) {
		return vaccinoDAO.listAllWithId(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Vaccino> cercaPerExample(VaccinoDTO input) {
		return vaccinoDAO.findWithExample(input);
	}

}
