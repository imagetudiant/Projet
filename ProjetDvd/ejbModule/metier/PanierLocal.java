package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Dvd;
import metier.entities.Panier;
import metier.entities.PanierHasDvdPK;

@Local
public interface PanierLocal {
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
	public void Fixer_quantité(PanierHasDvdPK p, Dvd d, int quantité);
	/**
	 * calcule la somme totale des prix des différents dvds dans un panier
	 * @param p
	 */
	void Somme_totale(Panier p);


}
