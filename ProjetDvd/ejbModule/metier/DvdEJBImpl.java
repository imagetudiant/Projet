package metier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Dvd;

@Stateful
public class DvdEJBImpl implements DvdLocal, DvdRemote {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Dvd searchDvd(int id) {
		Dvd d = em.find(Dvd.class, id);
		if(d==null) throw new RuntimeException("Dvd introuvable");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dvd> listDvd() {
		Query req =em.createQuery("select d from Dvd d");
		return req.getResultList();
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
	
	
	@Override
	public void editDvd(int id, String titre, double prix) {
		Dvd d= searchDvd(id);
		d.setTitre(titre);
		BigDecimal prixBD = BigDecimal.valueOf(prix);
		d.setPrix(prixBD);
	}

}
