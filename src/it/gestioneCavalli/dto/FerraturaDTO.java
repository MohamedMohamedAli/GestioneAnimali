package it.gestioneCavalli.dto;

public class FerraturaDTO {

	private Long idCavallo;
	private String maniscalco;
	private String dataDa;
	private String dataA;
	private String tipo;
	private String prezzoDa;
	private String prezzoA;

	public FerraturaDTO() {
		
	}
	
	public FerraturaDTO(Long idCavallo, String maniscalco, String dataDa, String dataA, String tipo, String prezzoDa,
			String prezzoA) {
		this.idCavallo = idCavallo;
		this.maniscalco = maniscalco;
		this.dataDa = dataDa;
		this.dataA = dataA;
		this.tipo = tipo;
		this.prezzoDa = prezzoDa;
		this.prezzoA = prezzoA;
	}

	public Long getIdCavallo() {
		return idCavallo;
	}

	public void setIdCavallo(Long idCavallo) {
		this.idCavallo = idCavallo;
	}

	public String getManiscalco() {
		return maniscalco;
	}

	public void setManiscalco(String maniscalco) {
		this.maniscalco = maniscalco;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
