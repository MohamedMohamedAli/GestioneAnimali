package it.gestioneCavalli.dto;

public class DocumentoDTO {

	private Long idAnimale;

	private String faldone;
	private String documento;

	public DocumentoDTO() {

	}

	public DocumentoDTO(Long idAnimale, String faldone, String documento) {
		this.idAnimale = idAnimale;
		this.faldone = faldone;
		this.documento = documento;
	}

	public Long getIdAnimale() {
		return idAnimale;
	}

	public void setIdAnimale(Long idAnimale) {
		this.idAnimale = idAnimale;
	}

	public String getFaldone() {
		return faldone;
	}

	public void setFaldone(String faldone) {
		this.faldone = faldone;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
