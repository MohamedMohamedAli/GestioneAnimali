package it.gestioneCavalli.dto;

public class CavalloDTO {

	private String nome;
	private String soprannome;
	private String tipo;
	private String sesso;
	private String daCorsa;
	private String puledro;
	private String rescue;
	private String fatrice;
	private String proprietario;
	private String colore;
	private String dataDa;
	private String dataA;
	private String padre;
	private String madre;
	private String microchip;
	private String passaporto;
	private String riconoscimentoPassaporto;
	private String attivo;
	private String disabilitato;

	public CavalloDTO() {
	}

	public CavalloDTO(String nome, String soprannome, String tipo, String daCorsa, String sesso, String puledro,
			String rescue, String fatrice, String dataDa, String dataA, String proprietario, String colore,
			String padre, String madre, String microchip, String passaporto, String riconoscimentoPassaporto,
			String attivo, String disabilitato) {
		this.nome = nome;
		this.soprannome = soprannome;
		this.tipo = tipo;
		this.daCorsa = daCorsa;
		this.sesso = sesso;
		this.puledro = puledro;
		this.rescue = rescue;
		this.fatrice = fatrice;
		this.proprietario = proprietario;
		this.colore = colore;
		this.dataDa = dataDa;
		this.dataA = dataA;
		this.padre = padre;
		this.madre = madre;
		this.microchip = microchip;
		this.passaporto = passaporto;
		this.riconoscimentoPassaporto = riconoscimentoPassaporto;
		this.attivo = attivo;
		this.disabilitato = disabilitato;
		this.setStato();
		this.setPerTipo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSoprannome() {
		return soprannome;
	}

	public void setSoprannome(String soprannome) {
		this.soprannome = soprannome;
	}

	public String getDaCorsa() {
		return daCorsa;
	}

	public void setDaCorsa(String daCorsa) {
		this.daCorsa = daCorsa;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPuledro() {
		return puledro;
	}

	public void setPuledro(String puledro) {
		this.puledro = puledro;
	}

	public String getRescue() {
		return rescue;
	}

	public void setRescue(String rescue) {
		this.rescue = rescue;
	}

	public String getFatrice() {
		return fatrice;
	}

	public void setFatrice(String fatrice) {
		this.fatrice = fatrice;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getPadre() {
		return padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
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

	public String getMadre() {
		return madre;
	}

	public void setMadre(String madre) {
		this.madre = madre;
	}

	public String getMicrochip() {
		return microchip;
	}

	public void setMicrochip(String microchip) {
		this.microchip = microchip;
	}

	public String getPassaporto() {
		return passaporto;
	}

	public void setPassaporto(String passaporto) {
		this.passaporto = passaporto;
	}

	public String getRiconoscimentoPassaporto() {
		return riconoscimentoPassaporto;
	}

	public void setRiconoscimentoPassaporto(String riconoscimentoPassaporto) {
		this.riconoscimentoPassaporto = riconoscimentoPassaporto;
	}

	public String getAttivo() {
		return attivo;
	}

	public void setAttivo(String attivo) {
		this.attivo = attivo;
	}

	public String getDisabilitato() {
		return disabilitato;
	}

	public void setDisabilitato(String disabilitato) {
		this.disabilitato = disabilitato;
	}

	public void setStato() {
		if ((this.attivo == null && this.disabilitato == null) || (this.attivo != null && this.disabilitato != null)) {
			this.attivo = null;
			return;
		}
		if (this.attivo != null) {
			this.attivo = "true";
		} else {
			this.attivo = "false";
		}
	}

	public void setPerTipo() {
		if (!"CAVALLO".equals(this.tipo)) {
			this.sesso = null;
			this.daCorsa = null;
			this.rescue = null;
			this.puledro = null;
			this.fatrice = null;
		} else if (!"F".equals(this.sesso)) {
			this.fatrice = null;
		}
	}

}
