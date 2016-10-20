package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Realisateur;

@Local
public interface RealisateurLocal {

	/**
	 * Recherche un r�alisateur via son identifiant.
	 * @param id l'identifiant du r�alisateur recherch�
	 * @return le r�alisateur recherch�
	 */
	public Realisateur getRealisateur(int id);
	
	/**
	 * Fournit l'ensemble des r�alisateurs existants.
	 * @return une liste des r�alisateurs existants.
	 */
	public List <Realisateur> listRealisateur();
	
	/**
	 * Recherche tous les r�alisateurs dont le nom correspond au nom recherch�.
	 * @param nomRech le nom du r�alisateur recherch�
	 * @return une liste de r�alisateurs dont le nom correspond au nom recherch�
	 */
	public List <Realisateur> searchRealisateur(String nomRech);
	
	/**
	 * Modifie un r�alisateur selon les valeurs fournies.
	 * @param id l'identifiant du r�alisateur � modifier
	 * @param nom le nouveau nom du r�alisateur
	 * @param prenom le nouveau prenom du r�alisateur
	 */
	public void editRealisateur(int id, String nom, String prenom);
}
