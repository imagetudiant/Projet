package metier;

import java.util.Date;

import javax.ejb.Local;

import metier.entities.Client;

@Local
public interface ClientLocal {
	
	public Client getClient(String email); 
	
	public boolean IsPassword(String password, String email);
	
	public String getEmail();
	
	public void setEmail(String email);

	public String getAdresse();

	public void setAdresse(String adresse);

	public Date getDateDeNaissance();

	public void setDateDeNaissance(Date dateDeNaissance);

	public void setMotDePasse(String motDePasse);

	public String getNom();

	public void setNom(String nom);

	public String getPrenom();

	public void setPrenom(String prenom);

	public String getSexe();

	public void setSexe(String sexe);

}
