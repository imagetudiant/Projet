package metier;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Dvd;

@Remote
public interface DvdRemote {
	
	/**
	 * Recherche un dvd via son identifiant.
	 * @param id l'identifiant du dvd recherché
	 * @return le dvd recherché
	 */
	public Dvd getDvd(int id);
	
	/**
	 * Recherche tous les dvd dont le titre correspond au titre recherché.
	 * @param titreRech le titre du dvd recherché
	 * @return une liste de dvd dont le titre correspond au titre recherché
	 */
	public List<Dvd> searchDvd(String titreRech);
	
	/**
	 * Fournit l'ensemble des dvd existants.
	 * @return une liste des dvd existants.
	 */
	public List<Dvd> listDvd();
	
	/**
	 * Modifie un dvd selon les valeurs fournies.
	 * @param id l'identifiant du dvd à modifier
	 * @param titre le nouveau titre du dvd
	 * @param prix le nouveau prix du dvd
	 */
	public void editDvd(int id, String titre, double prix);
	
	/**
	 * Crée un dvd dans la base de données.
	 * @param categorie la catégorie du dvd
	 * @param prix le prix du dvd
	 * @param stock la quantité en stock
	 * @param titre le titre du dvd
	 * @param auteur_id l'identifiant de l'auteur
	 * @param realisateur_id l'identifiant du réalisateur
	 */
	public void creerDvd(String categorie, double prix, int stock, String titre, int auteur_id, int realisateur_id);
	
	/**
	 * Modifie le réalisateur associé au dvd.
	 * @param id_realisateur l'identifiant du réalisateur du dvd
	 */
	public void setRealisateur(int id_realisateur);
	
	/**
	 * Modifie l'auteur associé au dvd.
	 * @param id_auteur l'identifiant de l'auteur du dvd
	 */
	public void setAuteur(int id_auteur);
	
	/**
	 * Supprime tous les dvds de la base de données.
	 */
	public void removeAll();
	
	/**
	 * Supprime un dvd de la base de données
	 * @param id l'identifiant du dvd à supprimer
	 */
	public void removeDvd(int id);
	
	/**
	 * Ajoute un dvd à la base de données.
	 * @param d le dvd à ajouter.
	 */
	public void addDvd(Dvd d);
	
	/**
	 * Modifie le titre d'un dvd
	 * @param id l'identifiant du dvd à modifier
	 * @param titre le nouveau titre du dvd
	 */
	public void setTitre(int id, String titre);
	//public void setdvd (int id);
	//public List<Dvd> getdvdbyauthor(long id_auteur);
	//public List<Dvd> getdvdbyrealisateur(long id_realisateur);
}
