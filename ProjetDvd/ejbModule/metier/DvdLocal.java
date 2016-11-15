package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Dvd;

@Local
public interface DvdLocal {
	
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
	
	//public void creerDvd(String categorie, double prix, double stock, String titre, int auteur_id, int realisateur_id);

	
	public void setRealisateur(int id_realisateur);
	public void setAuteur(int id_auteur);
	public void removeAll();
	public void removeDvd(int id);
	public void addDvd(Dvd d);
	//public void setdvdtitre(int id, String titre);
	//public void setdvd (int id);
	//public List<Dvd> getdvdbyauthor(long id_auteur);
	//public List<Dvd> getdvdbyrealisateur(long id_realisateur);
}
