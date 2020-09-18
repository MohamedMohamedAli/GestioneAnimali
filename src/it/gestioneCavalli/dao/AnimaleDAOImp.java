package it.gestioneCavalli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.gestioneCavalli.model.Animale;
import org.springframework.stereotype.Component;

import it.gestioneCavalli.dto.CavalloDTO;
import it.gestioneCavalli.utils.Utils;

@Component
public class AnimaleDAOImp implements AnimaleDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Animale> list() {
		return entityManager.createQuery("from Animale", Animale.class).getResultList();
	}

	@Override
	public Animale get(Long id) {
		return (Animale) entityManager.find(Animale.class, id);
	}

	@Override
	public void update(Animale input) {
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Animale input) {
		entityManager.persist(input);
	}

	@Override
	public void delete(Long id) {
		Animale animale = entityManager.find(Animale.class, id);
		if (animale == null) {
			return;
		}
		entityManager.remove(entityManager.merge(animale));
	}

	@Override
	public List<Animale> findByExampleDTO(CavalloDTO input) {
		String q = "select a from Animale a where 1=1 ";
		if (Utils.isNotBlank(input.getNome())) {
			q += "and a.nome like '%" + input.getNome() + "%' ";
		}
		if (Utils.isNotBlank(input.getSoprannome())) {
			q += "and a.soprannome like '%" + input.getSoprannome() + "%' ";
		}
		if (Utils.isNotBlank(input.getTipo())) {
			q += "and a.tipo like '%" + input.getTipo() + "%' ";
		}
		if (Utils.isNotBlank(input.getDaCorsa())) {
			q += "and a.daCorsa = " + input.getDaCorsa() + " ";
		}
		if (Utils.isNotBlank(input.getSesso())) {
			q += "and a.sesso like '" + input.getSesso() + "' ";
		}
		if (Utils.isNotBlank(input.getRescue())) {
			q += "and a.rescue = " + input.getRescue() + " ";
		}
		if (Utils.isNotBlank(input.getPuledro())) {
			q += "and a.puledro = " + input.getPuledro() + " ";
		}
		if (Utils.isNotBlank(input.getFatrice())) {
			q += "and a.fatrice = " + input.getFatrice() + " ";
		}
		if (Utils.isNotBlank(input.getProprietario())) {
			q += "and a.proprietario like '%" + input.getProprietario() + "%' ";
		}
		if (Utils.isNotBlank(input.getColore())) {
			q += "and a.colore like '%" + input.getColore() + "%' ";
		}
		if (Utils.isNotBlank(input.getDataDa())) {
			q += "and a.dataNascita >= '" + input.getDataDa() + "' ";
		}
		if (Utils.isNotBlank(input.getDataA())) {
			q += "and a.dataNascita <= '" + input.getDataA() + "' ";
		}
		if (Utils.isNotBlank(input.getPadre())) {
			q += "and a.padre like '%" + input.getPadre() + "%' ";
		}
		if (Utils.isNotBlank(input.getMadre())) {
			q += "and a.madre like '%" + input.getMadre() + "%' ";
		}
		if (Utils.isNotBlank(input.getMicrochip())) {
			q += "and a.microchip like '%" + input.getMicrochip() + "%' ";
		}
		if (Utils.isNotBlank(input.getPassaporto())) {
			q += "and a.passaporto like '%" + input.getPassaporto() + "%' ";
		}
		if (Utils.isNotBlank(input.getRiconoscimentoPassaporto())) {
			q += "and a.riconoscimentoPassaporto like '%" + input.getRiconoscimentoPassaporto() + "%' ";
		}
		if (Utils.isNotBlank(input.getAttivo())) {
			q += "and a.attivo = " + input.getAttivo() + " ";
		}
		return entityManager.createQuery(q, Animale.class).getResultList();
	}

}
