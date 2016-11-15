package metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Realisateur;

@Stateless(name="Realisateur")
public class RealisateurEJBImpl implements RealisateurLocal, RealisateurRemote {

	@PersistenceContext(unitName="ProjetDvd")
	private EntityManager em;
	
	@Override
	public Realisateur getRealisateur(int id) {
		Realisateur r = em.find(Realisateur.class, id);
		if(r==null) throw new RuntimeException("Réalisateur introuvable");
		return r;
	}

	@Override
	public List<Realisateur> listRealisateur() {
		Query req =em.createQuery("select a from Realisateur a");
		List<Realisateur> result = new ArrayList<Realisateur>();
		List<?> resultRaw = req.getResultList();
		Iterator <?> it = resultRaw.iterator();
		while (it.hasNext()) {
			result.add((Realisateur) it.next());
		}
		return result;
	}

	@Override
	public List<Realisateur> searchRealisateur(String nomRech) {
		List<Realisateur> result = new ArrayList<Realisateur>();
		if(nomRech == null) throw new RuntimeException("ERROR");
		if(nomRech == "") return result;
		List<Realisateur> list = listRealisateur();
		Iterator<Realisateur> it = list.iterator();
		while(it.hasNext()){
			Realisateur r = it.next();
			if(r.getNom().equals(nomRech)) {
				result.add(r);
			}		
		}
		return result;
	}

	@Override
	public void editRealisateur(int id, String nom, String prenom) {
		Realisateur r = getRealisateur(id);
		r.setNom(nom);
		r.setPrenom(prenom);
	}

	@Override
	public void addRealisateur(String nom, String prenom) {
		Realisateur r = new Realisateur(nom,prenom);
		em.persist(r);
	}

	@Override
	public void removeAll() {
		Query req = em.createQuery("delete from Realisateur");
		req.executeUpdate();
	}

}
