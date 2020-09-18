package it.gestioneCavalli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.gestioneCavalli.dto.DocumentoDTO;
import it.gestioneCavalli.model.Documento;
import it.gestioneCavalli.utils.Utils;

@Component
public class DocumentoDAOImp implements DocumentoDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Documento> list() {
		return entityManager.createQuery("from Documento", Documento.class).getResultList();
	}

	@Override
	public Documento get(Long id) {
		return (Documento) entityManager.find(Documento.class, id);
	}

	@Override
	public void update(Documento input) {
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Documento input) {
		entityManager.persist(input);
	}

	@Override
	public void delete(Long id) {
		
		Documento documento = entityManager.find(Documento.class, id);
		if (documento == null) {
			return;
		}
		entityManager.remove(entityManager.merge(documento));
	}

	@Override
	public List<Documento> findByExample(DocumentoDTO input) {
		String q = "select d from Animale a join a.documenti d where a.id = "+input.getIdAnimale()+" ";
		if(Utils.isNotBlank(input.getFaldone())) {
			q += "and d.faldone like '%"+input.getFaldone()+"%' ";
		}
		if(Utils.isNotBlank(input.getDocumento())) {
			q += "and d.documento like '%"+input.getDocumento()+"%' ";
		}
		return entityManager.createQuery(q, Documento.class).getResultList();
	}

	@Override
	public List<Documento> listAllWithId(Long id) {
		String q = "select d from Animale a join a.documenti d where a.id = "+id+"";
		return entityManager.createQuery(q, Documento.class).getResultList();
	}

}
