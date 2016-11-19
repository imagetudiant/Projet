package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Auteur;

@Local
public interface AuteurLocal {

	/**
	 * Recherche un auteur via son identifiant.
	 * @param id l'identifiant de l'auteur recherch�
	 * @return l'auteur recherch�
	 */
	public Auteur getAuteur(int id);
	
	/**
	 * Fournit l'ensemble des auteurs existants.
	 * @return une liste des auteurs existants.
	 */
	public List <Auteur> listAuteur();
	
	/**
	 * Recherche tous les auteurs dont le nom correspond au nom recherch�.
	 * @param nomRech le nom de l'auteur recherch�
	 * @return une liste d'auteurs dont le nom correspond au nom recherch�
	 */
	public List <Auteur> searchAuteur(String nomRech);
	
	/**
	 * Modifie un auteur selon les valeurs fournies.
	 * @param id l'identifiant de l'auteur � modifier
	 * @param nom le nouveau nom de l'auteur
	 * @param prenom le nouveau prenom de l'auteur
	 */
	public void editAuteur(int id, String nom, String prenom);
	
	/**
	 * Ajoute un auteur.
	 * @param nom le nom de l'auteur � ajouter
	 * @param prenom le pr�nom de l'auteur � ajouter
	 */
	public void addAuteur(String nom, String prenom);
	
	/**
	 * Supprime tous les auteurs.
	 */
	public void removeAll();
}
