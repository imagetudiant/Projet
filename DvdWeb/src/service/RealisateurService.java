package service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.RealisateurLocal;
import metier.entities.Realisateur;

@WebService
public class RealisateurService {
	
	@EJB
	private RealisateurLocal metier;
	
	@WebMethod
	public Realisateur getRealisateur(
			@WebParam(name="id") int id) {
		return metier.getRealisateur(id);
	}

	@WebMethod
	public List<Realisateur> searchRealisateur(
			@WebParam(name="titreRech") String titreRech) {
		return metier.searchRealisateur(titreRech);
	}

	@WebMethod
	public List<Realisateur> listRealisateur() {
		return metier.listRealisateur();
	}

	@WebMethod
	public void editRealisateur(
			@WebParam(name="id") int id,
			@WebParam(name="nom") String nom,
			@WebParam(name="prenom") String prenom) {
		metier.editRealisateur(id, nom, prenom);
	}
	
	@WebMethod
	public void addRealisateur(
			@WebParam(name="nom") String nom,
			@WebParam(name="prenom") String prenom) {
		metier.addRealisateur(nom, prenom);
	}
	
	@WebMethod
	public void removeAll() {
		metier.removeAll();
	}

}
