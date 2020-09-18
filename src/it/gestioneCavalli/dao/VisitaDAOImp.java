package it.gestioneCavalli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.gestioneCavalli.dto.VisitaDTO;
import it.gestioneCavalli.model.Visita;
import it.gestioneCavalli.utils.Utils;

@Component
public class VisitaDAOImp implements VisitaDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Visita> list() {
		return entityManager.createQuery("from Visita",Visita.class).getResultList();
	}

	@Override
	public Visita get(Long id) {
		return (Visita) entityManager.find(Visita.class, id);
	}

	@Override
	public void update(Visita input) {
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Visita input) {
		entityManager.persist(input);
	}

	@Override
	public void delete(Long id) {
		Visita visita = entityManager.find(Visita.class, id);
		if (visita == null) {
			return;
		}
		entityManager.remove(entityManager.merge(visita));
	}

	@Override
	public List<Visita> findByExample(VisitaDTO input) {
		String q = "select v from Animale a join a.visite v where a.id = " + input.getIdAnimale() + " ";
		if (Utils.isNotBlank(input.getVeterinario())) {
			q += "and v.veterinario like '%" + input.getVeterinario() + "%' ";
		}
		if (Utils.isNotBlank(input.getDataDa())) {
			q += "and v.data >= '" + input.getDataDa() + "' ";
		}
		if (Utils.isNotBlank(input.getDataA())) {
			q += "and v.data <= '" + input.getDataA() + "' ";
		}
		if (Utils.isNotBlank(input.getCausa())) {
			q += "and v.causa like '%" + input.getCausa() + "%' ";
		}
		if (Utils.isNotBlank(input.getTrattamento())) {
			q += "and v.trattamento like '%" + input.getTrattamento() + "%' ";
		}
		if (Utils.isNotBlank(input.getPrezzoDa())) {
			q += "and v.prezzo >= '" + input.getPrezzoDa() + "' ";
		}
		if (Utils.isNotBlank(input.getPrezzoA())) {
			q += "and v.prezzo <= '" + input.getPrezzoA() + "' ";
		}
		q += " order by v.data";
		return entityManager.createQuery(q, Visita.class).getResultList();
	}

	@Override
	public List<Visita> listAllWithId(Long id) {
		String q = "select v from Animale a join a.visite v where a.id = " + id + " order by v.data";
		return entityManager.createQuery(q, Visita.class).getResultList();
	}

	@Override
	public List<Visita> getWithDateVisita(String dataDa, String dataA) {
		String q = "select v from Visita v join fetch v.animale a where 1=1 ";
		if(Utils.isNotBlank(dataDa)) {
			q += "and v.data >='"+dataDa+"' ";
		}
		if(Utils.isNotBlank(dataA)) {
			q += "and v.data <='"+dataA+"' ";
		}
		q += " order by v.data";
		return entityManager.createQuery(q, Visita.class).getResultList();
	}
}
