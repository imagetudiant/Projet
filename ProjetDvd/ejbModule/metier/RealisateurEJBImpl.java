package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.entities.Realisateur;

@Stateless(name="Realisateur")
public class RealisateurEJBImpl implements RealisateurLocal, RealisateurRemote {

	@PersistenceContext(unitName="ProjetDvd")
	private EntityManager em;
	
	@Override
	public Realisateur getRealisateur(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Realisateur> listRealisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Realisateur> searchRealisateur(String nomRech) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editRealisateur(int id, String nom, String prenom) {
		// TODO Auto-generated method stub
		
	}

}
