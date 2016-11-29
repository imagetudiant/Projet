package metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private String email;

	private String adresse;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_de_naissance")
	private Date dateDeNaissance;

	@Column(name="mot_de_passe")
	private String motDePasse;

	private String nom;

	//@Column(name="panier_id")
	//private int panierId;

	private String prenom;

	private String sexe;

	public Client() {
	}
	/*
	public Client(String email, String password, String nom, String prenom, String adresse, Date date, String sexe, int panierId){
		this.email = email;
		this.motDePasse = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateDeNaissance = date;
		this.sexe = sexe;
		this.panierId = panierId;
	}
	*/
	
	 	public Client(String email, String password, String nom, String prenom, String adresse, Date date, String sexe){
		this.email = email;
		this.motDePasse = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateDeNaissance = date;
		this.sexe = sexe;
	}
	 

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
		
	/*public int getPanierId() {
		return this.panierId;
	}

	public void setPanierId(int panierId) {
		this.panierId = panierId;
	}*/

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

}