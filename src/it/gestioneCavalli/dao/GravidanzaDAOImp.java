package it.gestioneCavalli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.gestioneCavalli.dto.GravidanzaDTO;
import it.gestioneCavalli.model.Gravidanza;
import it.gestioneCavalli.utils.Utils;

@Component
public class GravidanzaDAOImp implements GravidanzaDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Gravidanza> list() {
		return entityManager.createQuery("from Gravidanza", Gravidanza.class).getResultList();
	}

	@Override
	public Gravidanza get(Long id) {
		return (Gravidanza) entityManager.find(Gravidanza.class, id);
	}

	@Override
	public void update(Gravidanza input) {
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Gravidanza input) {
		entityManager.persist(input);
	}

	@Override
	public void delete(Long id) {
		Gravidanza gravidanza = entityManager.find(Gravidanza.class, id);
		if (gravidanza == null) {
			return;
		}
		entityManager.remove(entityManager.merge(gravidanza));
	}

	@Override
	public List<Gravidanza> findByExampleDTO(GravidanzaDTO input) {
		String q = "select g from Gravidanza g where 1=1 ";
		if (Utils.isNotBlank(input.getStallonePadre())) {
			q += "and g.stallonePadre like '%" + input.getStallonePadre() + "%' ";
		}
		if (Utils.isNotBlank(input.getFatrice())) {
			q += "and g.fatrice like '%" + input.getFatrice() + "%' ";
		}
		if (Utils.isNotBlank(input.getPuledro())) {
			q += "and g.puledro like '%" + input.getPuledro() + "%' ";
		}
		if (Utils.isNotBlank(input.getInizioDa())) {
			q += "and g.dataInizio >= '" + input.getInizioDa() + "' ";
		}
		if (Utils.isNotBlank(input.getInizioA())) {
			q += "and g.dataInizio <= '" + input.getInizioA() + "' ";
		}
		if (Utils.isNotBlank(input.getPartoDa())) {
			q += "and g.dataFine >= '" + input.getPartoDa() + "' ";
		}
		if (Utils.isNotBlank(input.getPartoA())) {
			q += "and g.dataFine <= '" + input.getPartoA() + "' ";
		}
		q += " order by g.dataInizio desc";
		return entityManager.createQuery(q, Gravidanza.class).getResultList();

	}

	@Override
	public List<Gravidanza> findAttiviWithIdCavallo(Long idCavallo) {
		String q = "select g from Gravidanza g join g.cavallo c where g.completata = false and c.id = " + idCavallo;
		return entityManager.createQuery(q, Gravidanza.class).getResultList();
	}

	@Override
	public List<Gravidanza> listAllWithId(Long id) {
		String q = "select g from Gravidanza g join g.cavallo c where c.id = " + id;
		return entityManager.createQuery(q, Gravidanza.class).getResultList();
	}

	@Override
	public Gravidanza getEager(Long id) {
		String q = "select g from Gravidanza g join fetch g.cavallo c where g.id = " + id;
		return entityManager.createQuery(q, Gravidanza.class).getSingleResult();
	}

}
