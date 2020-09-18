package it.gestioneCavalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gestioneCavalli.dao.DocumentoDAO;
import it.gestioneCavalli.dto.DocumentoDTO;
import it.gestioneCavalli.model.Documento;
import it.gestioneCavalli.utils.Utils;

@Service
public class DocumentoServiceImp implements DocumentoService {

	@Autowired
	private DocumentoDAO documentoDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Documento> listAll() {
		return documentoDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Documento caricaConId(Long id) {
		return documentoDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Documento input) {
		Documento doc = documentoDAO.get(input.getId());
		doc.setFaldone(input.getFaldone());
		doc.setDocumento(input.getDocumento());
		doc.setNote(input.getNote());
		doc.setCartella(Utils.getLink("DOCUMENTO" + input.getId(), false));
		documentoDAO.update(doc);
	}

	@Transactional
	@Override
	public void inserisci(Documento input) {
		documentoDAO.insert(input);
		input.setCartella(Utils.getLink("DOCUMENTO" + input.getId(), false));
	}

	@Transactional
	@Override
	public void elimina(Long id) {
		documentoDAO.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Documento> cercaByExample(DocumentoDTO input) {
		return documentoDAO.findByExample(input);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Documento> listaConIdCavallo(Long id) {
		return documentoDAO.listAllWithId(id);
	}

}
