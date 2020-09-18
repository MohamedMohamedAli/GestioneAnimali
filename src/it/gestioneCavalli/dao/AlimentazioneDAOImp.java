package it.gestioneCavalli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.gestioneCavalli.model.Alimentazione;

@Component
public class AlimentazioneDAOImp implements AlimentazioneDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Alimentazione> list() {
		return entityManager.createQuery("from Alimentazione", Alimentazione.class).getResultList();
	}

	@Override
	public Alimentazione get(Long id) {
		return (Alimentazione) entityManager.find(Alimentazione.class, id);
	}

	@Override
	public void update(Alimentazione input) {
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Alimentazione input) {
		entityManager.persist(input);
	}

	@Override
	public void delete(Long id) {
		Alimentazione alimentazione = entityManager.find(Alimentazione.class, id);
		if (alimentazione == null) {
			return;
		}
		entityManager.remove(entityManager.merge(alimentazione));
	}

	@Override
	public List<Alimentazione> listAllWithId(Long id) {
		String q = "select a from Alimentazione a join a.animale an where an.id = " + id + " order by a.data desc";
		return entityManager.createQuery(q, Alimentazione.class).getResultList();
	}

}
