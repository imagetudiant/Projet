package metier;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Dvd;
import metier.entities.Panier;
import metier.entities.PanierHasDvdPK;

@Remote 
public interface PanierRemote {
	
	/**
	 * 
	 * renvoie la liste des relations qui lient Panier p et tous les 
	 * dvds correspondants
	 * @param p
	 * @return list
	 */
	public List<PanierHasDvdPK> Consulter_Panier(Panier p);
	/**
	 * permet d'ajouter unn dvd à un panier
	 * @param p
	 * @param d
	 */
	public void Ajout_Dvd(Panier p , Dvd d);
	/**
	 * permet de supprimer un dvd d'un panier 
	 * @param p
	 * @param d
	 */
	public void Supprimer_Dvd(PanierHasDvdPK p, Dvd d);
	/**
	 * permet de fixer la quantité d'un dvd dans un panier 
	 * @param p
	 * @param d
	 * @param quantité
	 */
	public void Fixer_quantite(PanierHasDvdPK p, Dvd d, int quantite);
	/**
	 * calcule la somme totale des prix des différents dvds dans un panier
	 * @param p
	 */
	public void Somme_totale(Panier p);
	
	/**
	 * Ajoute un panier � la base de donn�es.
	 */
	public int addPanier();
	
	/*
	public void addPanier(int clientId);
	*/
	

}
