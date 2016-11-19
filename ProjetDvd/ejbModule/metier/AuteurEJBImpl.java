package metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Auteur;

@Stateless(name="Auteur")
public class AuteurEJBImpl implements AuteurLocal, AuteurRemote {

	@PersistenceContext(unitName="ProjetDvd")
	private EntityManager em;
	
	@Override
	public Auteur getAuteur(int id) {
		Auteur a = em.find(Auteur.class, id);
		if(a==null) throw new RuntimeException("Auteur introuvable");
		return a;
	}

	@Override
	public List<Auteur> listAuteur() {
		Query req =em.createQuery("select a from Auteur a");
		List<Auteur> result = new ArrayList<Auteur>();
		List<?> resultRaw = req.getResultList();
		Iterator <?> it = resultRaw.iterator();
		while (it.hasNext()) {
			result.add((Auteur) it.next());
		}
		return result;
	}

	@Override
	public List<Auteur> searchAuteur(String nomRech) {
		List<Auteur> result = new ArrayList<Auteur>();
		if(nomRech == null) throw new RuntimeException("ERROR");
		if(nomRech == "") return result;
		List<Auteur> list = listAuteur();
		Iterator<Auteur> it = list.iterator();
		while(it.hasNext()){
			Auteur a = it.next();
			if(a.getNom().equals(nomRech)) {
				result.add(a);
			}		
		}
		return result;
	}

	@Override
	public void editAuteur(int id, String nom, String prenom) {
		Auteur a= getAuteur(id);
		a.setNom(nom);
		a.setPrenom(prenom);
	}

	@Override
	public void addAuteur(String nom, String prenom) {
		Auteur a = new Auteur(nom,prenom);
		em.persist(a);
	}

	@Override
	public void removeAll() {
		Query req = em.createQuery("delete from Auteur");
		req.executeUpdate();
	}

}
