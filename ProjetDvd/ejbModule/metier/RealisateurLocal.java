package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Realisateur;

@Local
public interface RealisateurLocal {

	/**
	 * Recherche un réalisateur via son identifiant.
	 * @param id l'identifiant du réalisateur recherché
	 * @return le réalisateur recherché
	 */
	public Realisateur getRealisateur(int id);
	
	/**
	 * Fournit l'ensemble des réalisateurs existants.
	 * @return une liste des réalisateurs existants.
	 */
	public List <Realisateur> listRealisateur();
	
	/**
	 * Recherche tous les réalisateurs dont le nom correspond au nom recherché.
	 * @param nomRech le nom du réalisateur recherché
	 * @return une liste de réalisateurs dont le nom correspond au nom recherché
	 */
	public List <Realisateur> searchRealisateur(String nomRech);
	
	/**
	 * Modifie un réalisateur selon les valeurs fournies.
	 * @param id l'identifiant du réalisateur à modifier
	 * @param nom le nouveau nom du réalisateur
	 * @param prenom le nouveau prenom du réalisateur
	 */
	public void editRealisateur(int id, String nom, String prenom);
}
