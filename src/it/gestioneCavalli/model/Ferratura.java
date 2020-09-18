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
public class Ferratura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String maniscalco;
	@Temporal(TemporalType.DATE)
	private Date data;
	private String tipo;
	private Double prezzo;
	private String note;
	private boolean completata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cavallo_id", nullable = false)
	private Animale cavallo;

	public Ferratura() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManiscalco() {
		return maniscalco;
	}

	public void setManiscalco(String maniscalco) {
		this.maniscalco = maniscalco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Animale getCavallo() {
		return cavallo;
	}

	public void setCavallo(Animale animale) {
		this.cavallo = animale;
	}

	public boolean isCompletata() {
		return completata;
	}

	public void setCompletata(boolean completata) {
		this.completata = completata;
	}

}
