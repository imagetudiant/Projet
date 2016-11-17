package metier;

import java.util.Date;

import javax.ejb.Remote;

import metier.entities.Client;

@Remote
public interface ClientRemote {
	
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