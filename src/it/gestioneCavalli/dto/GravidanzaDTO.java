package it.gestioneCavalli.dto;

public class GravidanzaDTO {

	private Long idCavallo;
	private String stallonePadre;
	private String fatrice;
	private String puledro;
	private String inizioDa;
	private String inizioA;
	private String partoDa;
	private String partoA;

	public GravidanzaDTO() {

	}

	public GravidanzaDTO(String stallonePadre, String fatrice, String puledro, String inizioDa, String inizioA,
			String partoDa, String partoA) {
		this.stallonePadre = stallonePadre;
		this.fatrice = fatrice;
		this.puledro = puledro;
		this.inizioDa = inizioDa;
		this.inizioA = inizioA;
		this.partoDa = partoDa;
		this.partoA = partoA;
	}

	public Long getIdCavallo() {
		return idCavallo;
	}

	public void setIdCavallo(Long idCavallo) {
		this.idCavallo = idCavallo;
	}

	public String getFatrice() {
		return fatrice;
	}

	public void setFatrice(String fatrice) {
		this.fatrice = fatrice;
	}

	public String getInizioDa() {
		return inizioDa;
	}

	public void setInizioDa(String inizioDa) {
		this.inizioDa = inizioDa;
	}

	public String getInizioA() {
		return inizioA;
	}

	public void setInizioA(String inizioA) {
		this.inizioA = inizioA;
	}

	public String getPartoDa() {
		return partoDa;
	}

	public void setPartoDa(String partoDa) {
		this.partoDa = partoDa;
	}

	public String getPartoA() {
		return partoA;
	}

	public void setPartoA(String partoA) {
		this.partoA = partoA;
	}

	public String getStallonePadre() {
		return stallonePadre;
	}

	public void setStallonePadre(String stallonePadre) {
		this.stallonePadre = stallonePadre;
	}

	public String getPuledro() {
		return puledro;
	}

	public void setPuledro(String puledro) {
		this.puledro = puledro;
	}

}
