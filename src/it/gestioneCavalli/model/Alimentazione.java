package it.gestioneCavalli.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Alimentazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date data;
	private Integer quantita;
	private String integratori; 
	private Double prezzo;
	private String note;
	private boolean ordinata;
	private Integer frequenza;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "animale_id", nullable = false)
	private Animale animale;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public String getIntegratori() {
		return integratori;
	}
	public void setIntegratori(String integratori) {
		this.integratori = integratori;
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
	public boolean isOrdinata() {
		return ordinata;
	}
	public void setOrdinata(boolean ordinata) {
		this.ordinata = ordinata;
	}
	public Integer getFrequenza() {
		return frequenza;
	}
	public void setFrequenza(Integer frequenza) {
		this.frequenza = frequenza;
	}
	public Animale getAnimale() {
		return animale;
	}
	public void setAnimale(Animale animale) {
		this.animale = animale;
	}
}
