package metier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Auteur;
import metier.entities.Dvd;
import metier.entities.Realisateur;

@Stateless(name="dvd")
public class DvdEJBImpl implements DvdLocal, DvdRemote {
	@PersistenceContext(unitName="ProjetDvd")
	private EntityManager em;
	
	@Override
	public void editDvd(int id, String titre, double prix) {
		Dvd d= getDvd(id);
		d.setTitre(titre);
		BigDecimal prixBD = BigDecimal.valueOf(prix);
		d.setPrix(prixBD);
	}
	@Override
	public Dvd getDvd(int id) {
		Dvd d = em.find(Dvd.class, id);
		if(d==null) throw new RuntimeException("Dvd introuvable");
		return d;
	}

	@Override
	public List<Dvd> listDvd() {
		Query req =em.createQuery("select d from Dvd d");
		List<Dvd> result = new ArrayList<Dvd>();
		List<?> resultRaw = req.getResultList();
		Iterator <?> it = resultRaw.iterator();
		while (it.hasNext()) {
			result.add((Dvd) it.next());
		}
		return result;
		}
	
	public List<Dvd> searchDvd(String titreRech) {
		List<Dvd> result = new ArrayList<Dvd>();
		if(titreRech == null) throw new RuntimeException("ERROR");
		if(titreRech == "") return result;
		List<Dvd> list = listDvd();
		Iterator<Dvd> it = list.iterator();
		while(it.hasNext()){
			Dvd d = it.next();
			if(d.getTitre().equals(titreRech)) {
				result.add(d);
			}
			
		}
		return result;
	}

	public void setRealisateur(int id_realisateur){
		Dvd d = em.find(Dvd.class, id_realisateur);
		Realisateur r= d.getRealisateur();
		em.persist(r);
	}
	
	public void setAuteur(int id_auteur){
		Dvd d = em.find(Dvd.class, id_auteur);
		Auteur r= d.getAuteur();
		em.persist(r);
		}
	
	public void addDvd(Dvd d){
		em.persist(d);
	}
    
	
	public void removeAll(){
		List<Dvd> result = new ArrayList<Dvd>();
		Iterator<Dvd> it = result.iterator();
		while(it.hasNext()){
			Dvd d = it.next();
			em.remove(d);
		}
	}
	
	public void removeDvd(int id) {
		List<Dvd> result = new ArrayList<Dvd>();
		Iterator<Dvd> it = result.iterator();
		 while(it.hasNext()){
			 Dvd d = it.next();
			 if (id == d.getId()){
				 em.remove(d);
			 }
		 }
	}
	
	//public void setdvdtitre(int id, String titre);
	//public void setdvd (int id);
	//public List<Dvd> getdvdbyauthor(long id_auteur) {}
	//public List<Dvd> getdvdbyrealisateur(long id_realisateur) {}
	

}
