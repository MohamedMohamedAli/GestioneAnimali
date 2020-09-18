package it.gestioneCavalli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.gestioneCavalli.dto.FerraturaDTO;
import it.gestioneCavalli.model.Ferratura;
import it.gestioneCavalli.utils.Utils;

@Component
public class FerraturaDAOImp implements FerraturaDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Ferratura> list() {
		return entityManager.createQuery("from Ferratura", Ferratura.class).getResultList();
	}

	@Override
	public Ferratura get(Long id) {
		return (Ferratura) entityManager.find(Ferratura.class, id);
	}

	@Override
	public void update(Ferratura input) {
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Ferratura input) {
		entityManager.persist(input);
	}

	@Override
	public void delete(Long id) {
		Ferratura ferratura = entityManager.find(Ferratura.class, id);
		if (ferratura == null) {
			return;
		}
		entityManager.remove(entityManager.merge(ferratura));
	}

	@Override
	public List<Ferratura> findByExample(FerraturaDTO input) {
		String q = "select f from Animale a join a.ferrature f where a.id = " + input.getIdCavallo() + " ";
		if (Utils.isNotBlank(input.getManiscalco())) {
			q += "and f.maniscalco like '%" + input.getManiscalco() + "%' ";
		}
		if (Utils.isNotBlank(input.getDataDa())) {
			q += "and f.data >= '" + input.getDataDa() + "' ";
		}
		if (Utils.isNotBlank(input.getDataA())) {
			q += "and f.data <= '" + input.getDataA() + "' ";
		}
		if (Utils.isNotBlank(input.getTipo())) {
			q += "and f.tipo like '%" + input.getTipo() + "%' ";
		}
		if (Utils.isNotBlank(input.getPrezzoDa())) {
			q += "and f.prezzo >= '" + input.getPrezzoDa() + "' ";
		}
		if (Utils.isNotBlank(input.getPrezzoA())) {
			q += "and f.prezzo <= '" + input.getPrezzoA() + "' ";
		}
		q += " order by f.data";
		return entityManager.createQuery(q, Ferratura.class).getResultList();
	}

	@Override
	public List<Ferratura> listAllWithId(Long id) {
		String q = "select f from Animale a join a.ferrature f where a.id = " + id + " order by f.data desc";
		return entityManager.createQuery(q, Ferratura.class).getResultList();
	}

	@Override
	public List<Ferratura> getWithDateFerratura(String dataDa, String dataA) {
		String q = "select f from Ferratura f join fetch f.cavallo c where f.completata = 1 ";
		if (Utils.isNotBlank(dataDa)) {
			q += "and f.data >='" + dataDa + "' ";
		}
		if (Utils.isNotBlank(dataA)) {
			q += "and f.data <='" + dataA + "' ";
		}
		q += " order by f.data";
		return entityManager.createQuery(q, Ferratura.class).getResultList();
	}

	@Override
	public void deleteByCavallo(Long id) {
		String q = "delete f from Ferratura f join f.cavallo c where a.id = " + id;
		entityManager.createQuery(q, Ferratura.class);
	}

	@Override
	public List<Ferratura> getAllPrenotati() {
		String q = "select f from Ferratura f join fetch f.cavallo c where f.completata = 0 order by f.data";
		return entityManager.createQuery(q, Ferratura.class).getResultList();
	}

	@Override
	public Ferratura getEager(Long id) {
		String q = "select f from Ferratura f join fetch f.cavallo c where f.id = " + id;
		return entityManager.createQuery(q, Ferratura.class).getSingleResult();
	}

	@Override
	public List<Ferratura> findByExamplePrenotati(FerraturaDTO input) {
		String q = "select f from Ferratura f join fetch f.cavallo c where f.completata = 0 ";
		if (Utils.isNotBlank(input.getDataDa())) {
			q += "and f.data >= '" + input.getDataDa() + "' ";
		}
		if (Utils.isNotBlank(input.getDataA())) {
			q += "and f.data <= '" + input.getDataA() + "' ";
		}
		if (Utils.isNotBlank(input.getTipo())) {
			q += "and f.tipo like '%" + input.getTipo() + "%' ";
		}
		q += " order by f.data";
		return entityManager.createQuery(q, Ferratura.class).getResultList();
	}
}
