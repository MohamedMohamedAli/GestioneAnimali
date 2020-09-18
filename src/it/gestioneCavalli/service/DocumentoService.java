package it.gestioneCavalli.service;

import java.util.List;

import it.gestioneCavalli.dto.DocumentoDTO;
import it.gestioneCavalli.model.Documento;

public interface DocumentoService extends IBaseService<Documento>{

	List<Documento> cercaByExample(DocumentoDTO input);
	
	List<Documento> listaConIdCavallo(Long id);
}
