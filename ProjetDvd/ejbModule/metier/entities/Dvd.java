package metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the dvd database table.
 * 
 */
@Entity
@NamedQuery(name="Dvd.findAll", query="SELECT d FROM Dvd d")
public class Dvd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String categorie;

	private BigDecimal prix;

	private int stock;

	private String titre;

	//bi-directional many-to-one association to Auteur
	@ManyToOne
	private Auteur auteur;

	//bi-directional many-to-one association to Realisateur
	@ManyToOne
	private Realisateur realisateur;

	public Dvd() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Auteur getAuteur() {
		return this.auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Realisateur getRealisateur() {
		return this.realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

}