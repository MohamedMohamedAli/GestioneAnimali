package it.gestioneCavalli.dto;

public class VisitaDTO {
	private Long idAnimale;
	private String veterinario;
	private String dataDa;
	private String dataA;
	private String causa;
	private String trattamento;
	private String prezzoDa;
	private String prezzoA;

	public VisitaDTO() {

	}

	public VisitaDTO(Long idAnimale, String veterinario, String dataDa, String dataA, String causa, String trattamento,
					 String prezzoDa, String prezzoA) {
		this.idAnimale = idAnimale;
		this.veterinario = veterinario;
		this.dataDa = dataDa;
		this.dataA = dataA;
		this.causa = causa;
		this.trattamento = trattamento;
		this.prezzoDa = prezzoDa;
		this.prezzoA = prezzoA;
	}

	public Long getIdAnimale() {
		return idAnimale;
	}

	public void setIdAnimale(Long idAnimale) {
		this.idAnimale = idAnimale;
	}

	public String getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}

	public String getDataDa() {
		return dataDa;
	}

	public void setDataDa(String dataDa) {
		this.dataDa = dataDa;
	}

	public String getDataA() {
		return dataA;
	}

	public void setDataA(String dataA) {
		this.dataA = dataA;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getTrattamento() {
		return trattamento;
	}

	public void setTrattamento(String trattamento) {
		this.trattamento = trattamento;
	}

	public String getPrezzoDa() {
		return prezzoDa;
	}

	public void setPrezzoDa(String prezzoDa) {
		this.prezzoDa = prezzoDa;
	}

	public String getPrezzoA() {
		return prezzoA;
	}

	public void setPrezzoA(String prezzoA) {
		this.prezzoA = prezzoA;
	}

}
