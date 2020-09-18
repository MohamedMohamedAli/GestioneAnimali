package it.gestioneCavalli.dto;

public class VaccinoDTO {

	private String tipo;
	private String dataDa;
	private String dataA;

	public VaccinoDTO() {

	}

	public VaccinoDTO(String tipo, String dataDa, String dataA) {
		this.tipo = tipo;
		this.dataDa = dataDa;
		this.dataA = dataA;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

}
