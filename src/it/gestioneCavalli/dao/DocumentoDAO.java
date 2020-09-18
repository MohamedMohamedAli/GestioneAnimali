package it.gestioneCavalli.dao;

import java.util.List;

import it.gestioneCavalli.dto.DocumentoDTO;
import it.gestioneCavalli.model.Documento;

public interface DocumentoDAO extends IBaseDAO<Documento>{

	List<Documento> findByExample(DocumentoDTO input);
	
	List<Documento> listAllWithId(Long id);

}
