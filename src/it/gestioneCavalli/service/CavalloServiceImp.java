package it.gestioneCavalli.service;

import java.util.List;

import it.gestioneCavalli.model.Animale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestioneCavalli.dao.AnimaleDAO;
import it.gestioneCavalli.dao.FerraturaDAO;
import it.gestioneCavalli.dao.GravidanzaDAO;
import it.gestioneCavalli.dto.CavalloDTO;
import it.gestioneCavalli.model.Ferratura;
import it.gestioneCavalli.model.Gravidanza;
import it.gestioneCavalli.utils.Utils;

@Service
public class CavalloServiceImp implements CavalloService {

	@Autowired
	private AnimaleDAO animaleDAO;

	@Autowired
	private FerraturaDAO ferraturaDAO;

	@Autowired
	private GravidanzaDAO gravidanzaDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Animale> listAll() {
		return animaleDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Animale caricaConId(Long id) {
		return animaleDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Animale input) {
		Animale animale = Utils.setPerTipo(input);
		animale.setFoto(Utils.getLink("FOTO" + animale.getId(), true));

		if (!"CAVALLO".equals(animale.getTipo())) {
			List<Ferratura> ferrature = ferraturaDAO.listAllWithId(animale.getId());
			List<Gravidanza> gravidanze = gravidanzaDAO.listAllWithId(animale.getId());
			if (ferrature != null) {
				ferrature.forEach(ferratura -> {
					ferraturaDAO.delete(ferratura.getId());
				});
			}
			if (gravidanze != null) {
				gravidanze.forEach(gravidanza -> {
					gravidanzaDAO.delete(gravidanza.getId());
				});
			}
		} else {
			input.getGravidanze().forEach(e -> {
				if (input.isFatrice()|| e.isCompletata()) {
					gravidanzaDAO.update(e);
				} else if (e.getId() != null) {
					gravidanzaDAO.delete(e.getId());
				}
			});
		}

		animaleDAO.update(input);
	}

	@Transactional
	@Override
	public void inserisci(Animale input) {
		Animale animale = Utils.setPerTipo(input);
		animaleDAO.insert(animale);
		if (animale.isFatrice()) {
			input.getGravidanze().forEach(e -> {
				e.setCavallo(animale);
				gravidanzaDAO.insert(e);
			});
		}
		input.setFoto(Utils.getLink("FOTO" + animale.getId(), true));
	}

	@Transactional
	@Override
	public void elimina(Long id) {
		animaleDAO.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Animale> cercaByExample(CavalloDTO input) {
		return animaleDAO.findByExampleDTO(input);
	}

}
