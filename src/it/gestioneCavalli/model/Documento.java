package it.gestioneCavalli.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String faldone;
	private String documento;
	private String cartella;
	private String note;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "animale_id", nullable = false)
	private Animale animale;

	public Documento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFaldone() {
		return faldone;
	}

	public void setFaldone(String faldone) {
		this.faldone = faldone;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCartella() {
		return cartella;
	}

	public void setCartella(String cartella) {
		this.cartella = cartella;
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
