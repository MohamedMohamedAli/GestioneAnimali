package it.gestioneCavalli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.gestioneCavalli.dto.VaccinoDTO;
import it.gestioneCavalli.model.Vaccino;
import it.gestioneCavalli.utils.Utils;

@Component
public class VaccinoDAOImp implements VaccinoDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Vaccino> list() {
		String q = "select v from Vaccino v join fetch v.animale a order by v.data";
		return entityManager.createQuery(q, Vaccino.class).getResultList();
	}

	@Override
	public Vaccino get(Long id) {
		return (Vaccino) entityManager.find(Vaccino.class, id);
	}

	@Override
	public void update(Vaccino input) {
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Vaccino input) {
		entityManager.persist(input);
	}

	@Override
	public void delete(Long id) {
		Vaccino vaccino = entityManager.find(Vaccino.class, id);
		if (vaccino == null) {
			return;
		}
		entityManager.remove(entityManager.merge(vaccino));
	}

	@Override
	public List<Vaccino> listAllWithId(Long id) {
		String q = "select v from Animale a join a.vaccini v where a.id = " + id + " order by v.data";
		return entityManager.createQuery(q, Vaccino.class).getResultList();

	}

	@Override
	public List<Vaccino> findWithExample(VaccinoDTO input) {
		String q = "select v from Vaccino v join fetch v.cavallo where 1=1 ";
		if (Utils.isNotBlank(input.getTipo())) {
			q += "and v.tipo like '%" + input.getTipo() + "%' ";
		}
		if (Utils.isNotBlank(input.getDataDa())) {
			q += "and v.data >= '" + input.getDataDa() + "' ";
		}
		if (Utils.isNotBlank(input.getDataA())) {
			q += "and v.data <= '" + input.getDataA() + "' ";
		}
		q+= "order by v.data";
		return entityManager.createQuery(q, Vaccino.class).getResultList();
	}

}
