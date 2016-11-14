package service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.AuteurLocal;
import metier.entities.Auteur;

@WebService
public class AuteurService {
	
	@EJB
	private AuteurLocal metier;
	
	@WebMethod
	public Auteur getAuteur(
			@WebParam(name="id") int id) {
		return metier.getAuteur(id);
	}

	@WebMethod
	public List<Auteur> searchAuteur(
			@WebParam(name="titreRech") String titreRech) {
		return metier.searchAuteur(titreRech);
	}

	@WebMethod
	public List<Auteur> listAuteur() {
		return metier.listAuteur();
	}

	@WebMethod
	public void editAuteur(
			@WebParam(name="id") int id,
			@WebParam(name="nom") String nom,
			@WebParam(name="prenom") String prenom) {
		metier.editAuteur(id, nom, prenom);
	}
	
	@WebMethod
	public void addAuteur(
			@WebParam(name="nom") String nom,
			@WebParam(name="prenom") String prenom) {
		metier.addAuteur(nom, prenom);
	}
	
	@WebMethod
	public void removeAll() {
		metier.removeAll();
	}

}
