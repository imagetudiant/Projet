package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.entities.Auteur;

@Stateless(name="Auteur")
public class AuteurEJBImpl implements AuteurLocal, AuteurRemote {

	@PersistenceContext(unitName="ProjetDvd")
	private EntityManager em;
	
	@Override
	public Auteur getAuteur(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auteur> listAuteur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auteur> searchAuteur(String nomRech) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editAuteur(int id, String nom, String prenom) {
		// TODO Auto-generated method stub
		
	}

}
