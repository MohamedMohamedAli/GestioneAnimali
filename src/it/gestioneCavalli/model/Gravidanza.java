package it.gestioneCavalli.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Gravidanza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	@Temporal(TemporalType.DATE)
	private Date dataFine;
	private String stallonePadre;
	private String fatrice;
	private String puledro;
	private boolean completata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cavallo_id", nullable = false)
	private Animale cavallo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getStallonePadre() {
		return stallonePadre;
	}

	public void setStallonePadre(String stallonePadre) {
		this.stallonePadre = stallonePadre;
	}

	public String getFatrice() {
		return fatrice;
	}

	public void setFatrice(String fatrice) {
		this.fatrice = fatrice;
	}

	public Animale getCavallo() {
		return cavallo;
	}

	public void setCavallo(Animale animale) {
		this.cavallo = animale;
	}

	public String getPuledro() {
		return puledro;
	}

	public void setPuledro(String puledro) {
		this.puledro = puledro;
	}

	public boolean isCompletata() {
		return completata;
	}

	public void setCompletata(boolean completata) {
		this.completata = completata;
	}
	
}
