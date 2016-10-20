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
	
}
