package metier;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import metier.entities.Client;


@Stateful(name="Client")
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30)
public class ClientEJBImpl implements ClientLocal, ClientRemote {
	
	private String clientEmail;

	@PersistenceContext(unitName="ProjetDvd")
	private EntityManager em;
	
	@Override
	public void login(String email) {
		this.clientEmail = email;
	}
	
	@Override
	public void logout() {
		this.clientEmail = null;
	}
	
	@Override
	public Client getClient(String email) {
		if (email == null) throw new RuntimeException("email is null");
		Client c = em.find(Client.class, email);
		if(c == null) throw new RuntimeException("email error");
		return c;
	}
    
	
	/*
	public void addClient(String email, String password, String nom, String prenom, String adresse, Date date, String sexe, int panierId){
		    Client c = new Client(email, password, nom, prenom, adresse, date, sexe, panierId);
		    em.merge(c);		
	}*/
	
	@Override
	public void addClient(String email, String password, String nom, String prenom, String adresse, Date date, String sexe){
		    Client c = new Client(email, password, nom, prenom, adresse, date, sexe);
		    em.merge(c);
		   
	}
	 
	
	@Override
	public boolean IsClient(String email) {
		Client c = em.find(Client.class, email);
		if(c == null){
			return false;
		}
		else { 
			return true;
		}
		
	}
	@Override
	public boolean IsPassword(String password, String email) {
		Client c = getClient(email);
		String pwd = c.getMotDePasse();
		if(pwd.equals(password)){
			return true;
		}
		else return false;
	}

	@Override
	public String getEmail() {
		return clientEmail; 
	}

	@Override
	public void setEmail(String email) {
		this.clientEmail = email;
	}

	@Override
	public String getAdresse() {
	  Client c = getClient(this.clientEmail);
	  return c.getAdresse();
	}

	@Override
	public void setAdresse(String adresse) {
		Client c = getClient(this.clientEmail);
		c.setAdresse(adresse);
	}

	@Override
	public Date getDateDeNaissance() {
		  Client c = getClient(this.clientEmail);
		  return c.getDateDeNaissance();
	}

	@Override
	public void setDateDeNaissance(Date dateDeNaissance) {
		  Client c = getClient(this.clientEmail);
		  c.setDateDeNaissance(dateDeNaissance);
		
	}

	@Override
	public void setMotDePasse(String motDePasse) {
		  Client c = getClient(this.clientEmail);
		  c.setMotDePasse(motDePasse);		
	}

	@Override
	public String getNom() {
		  Client c = getClient(this.clientEmail);
		  return c.getNom();
	}

	@Override
	public void setNom(String nom) {
		  Client c = getClient(this.clientEmail);
		  c.setNom(nom);
	}

	@Override
	public String getPrenom() {
		  Client c = getClient(this.clientEmail);
		  return c.getPrenom();
	}

	@Override
	public void setPrenom(String prenom) {
		  Client c = getClient(this.clientEmail);
		  c.setPrenom(prenom);
		
	}

	@Override
	public String getSexe() {
		  Client c = getClient(this.clientEmail);
		  return c.getSexe();
	}

	@Override
	public void setSexe(String sexe) {
		  Client c = getClient(this.clientEmail);
		  c.setSexe(sexe);
		
	}

	
}
