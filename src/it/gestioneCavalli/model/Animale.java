package it.gestioneCavalli.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Animale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String soprannome;
	private String tipo;
	private boolean fatrice;
	private boolean rescue;
	private boolean puledro;
	private String sesso;
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	private String proprietario;
	private String colore;
	private String padre;
	private String Madre;
	private String microchip;
	private String passaporto;
	private String riconoscimentoPassaporto;
	private String foto;
	private String note;
	private boolean daCorsa;
	private boolean attivo;

	@OneToMany(mappedBy = "cavallo", orphanRemoval = true)
	private List<Gravidanza> gravidanze = new ArrayList<Gravidanza>();
	@OneToMany(mappedBy = "animale", orphanRemoval = true)
	private List<Visita> visite = new ArrayList<Visita>();
	@OneToMany(mappedBy = "cavallo", orphanRemoval = true)
	private List<Ferratura> ferrature = new ArrayList<Ferratura>();
	@OneToMany(mappedBy = "animale", orphanRemoval = true)
	private List<Documento> documenti = new ArrayList<Documento>();
	@OneToMany(mappedBy = "animale", orphanRemoval = true)
	private List<Vaccino> vaccini = new ArrayList<Vaccino>();
	@OneToMany(mappedBy = "animale", orphanRemoval = true)
	private List<Alimentazione> alimentazioni = new ArrayList<Alimentazione>();

	public Animale() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isFatrice() {
		return fatrice;
	}

	public void setFatrice(boolean fatrice) {
		this.fatrice = fatrice;
	}

	public boolean isRescue() {
		return rescue;
	}

	public void setRescue(boolean rescue) {
		this.rescue = rescue;
	}

	public boolean isPuledro() {
		return puledro;
	}

	public void setPuledro(boolean puledro) {
		this.puledro = puledro;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
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

	public String getMadre() {
		return Madre;
	}

	public void setMadre(String madre) {
		Madre = madre;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public List<Visita> getVisite() {
		return visite;
	}

	public void setVisite(List<Visita> visite) {
		this.visite = visite;
	}

	public List<Ferratura> getFerrature() {
		return ferrature;
	}

	public void setFerrature(List<Ferratura> ferrature) {
		this.ferrature = ferrature;
	}

	public List<Documento> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(List<Documento> documenti) {
		this.documenti = documenti;
	}

	public boolean isDaCorsa() {
		return daCorsa;
	}

	public void setDaCorsa(boolean daCorsa) {
		this.daCorsa = daCorsa;
	}

	public List<Vaccino> getVaccini() {
		return vaccini;
	}

	public void setVaccini(List<Vaccino> vaccini) {
		this.vaccini = vaccini;
	}

	public List<Gravidanza> getGravidanze() {
		return gravidanze;
	}

	public void setGravidanze(List<Gravidanza> gravidanze) {
		this.gravidanze = gravidanze;
	}

	public List<Alimentazione> getAlimentazioni() {
		return alimentazioni;
	}

	public void setAlimentazioni(List<Alimentazione> alimentazioni) {
		this.alimentazioni = alimentazioni;
	}
	

}
