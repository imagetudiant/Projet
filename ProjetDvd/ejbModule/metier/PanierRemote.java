package metier;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Dvd;
import metier.entities.Panier;
import metier.entities.PanierHasDvdPK;

@Remote 
public interface PanierRemote {
	
	
	/**
	 * Donne le panier correspondant ‡ un email
	 * @return un panier
	 */
	public Panier getPanier();
	
	/**
	 * 
	 * renvoie la liste des dvds correspondant ‡ un panier
	 * @param email l'id du panier
	 * @return list
	 */
	public List<Dvd> Consulter_Panier();
	/**
	 * permet d'ajouter unn dvd √† un panier
	 * @param p
	 * @param d
	 */
	public void Ajout_Dvd(Panier p , Dvd d);
	/**
	 * permet de supprimer un dvd d'un panier 
	 * @param p
	 * @param d
	 */
	public void supprimerDvd(Panier p, Dvd d);
	/**
	 * permet de fixer la quantit√© d'un dvd dans un panier 
	 * @param p
	 * @param d
	 * @param quantit√©
	 */
	public void Fixer_quantite(PanierHasDvdPK p, Dvd d, int quantite);
	/**
	 * calcule la somme totale des prix des diff√©rents dvds dans un panier
	 * @param p
	 */
	public void Somme_totale();
	
	/**
	 * Ajoute un panier ‡ la base de donnÈes.
	 */
	
	/*
	public int addPanier();*/
	
	
	public void addPanier(String email);
	
	public void login(String email);
	
	public void logout();
	
	

}
