package metier.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the realisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Realisateur.findAll", query="SELECT r FROM Realisateur r")
public class Realisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nom;

	private String prenom;

	public Realisateur() {
	}
	
	public Realisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
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

	public String getFullName() {
		return this.prenom + " " + this.nom;
	}

}