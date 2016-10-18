package metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the auteur database table.
 * 
 */
@Entity
@NamedQuery(name="Auteur.findAll", query="SELECT a FROM Auteur a")
public class Auteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Dvd
	@OneToMany(mappedBy="auteur")
	private List<Dvd> dvds;

	public Auteur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Dvd> getDvds() {
		return this.dvds;
	}

	public void setDvds(List<Dvd> dvds) {
		this.dvds = dvds;
	}

	public Dvd addDvd(Dvd dvd) {
		getDvds().add(dvd);
		dvd.setAuteur(this);

		return dvd;
	}

	public Dvd removeDvd(Dvd dvd) {
		getDvds().remove(dvd);
		dvd.setAuteur(null);

		return dvd;
	}

}