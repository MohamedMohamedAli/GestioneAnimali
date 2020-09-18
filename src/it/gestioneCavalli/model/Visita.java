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
public class Visita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String veterinario;
	@Temporal(TemporalType.DATE)
	private Date data;
	private String diagnosi;
	private String causa;
	private String trattamento;
	private Double prezzo;
	private String note;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "animale_id", nullable = false)
	private Animale animale;

	public Visita() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDiagnosi() {
		return diagnosi;
	}

	public void setDiagnosi(String diagnosi) {
		this.diagnosi = diagnosi;
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

	public Animale getAnimale() {
		return animale;
	}

	public void setAnimale(Animale animale) {
		this.animale = animale;
	}

}
