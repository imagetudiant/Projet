package metier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import metier.entities.Dvd;
import metier.entities.Panier;
import metier.entities.PanierHasDvd;
import metier.entities.PanierHasDvdPK;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful(name="Panier")
public class PanierEJBImpl implements PanierRemote, PanierLocal{
	
	private String email;

	@PersistenceContext(unitName="ProjetDvd")
	private EntityManager em;
	
	@Override
	public void login(String email) {
		this.email = email;
	}
	
	@Override
	public void logout() {
		this.email = null;
	}
	
	@Override
	public Panier getPanier() {
		Panier p = em.find(Panier.class, email);
		if(p==null) throw new RuntimeException("Panier introuvable");
		return p;
	}
	
	@Override
	public List<Dvd> Consulter_Panier() {
		List<Dvd> liste = new ArrayList <Dvd> ();
		if (email == null) {
			return liste;
		}
		else {
		Query req =em.createNamedQuery("PanierHasDvd.findAll");
		List<PanierHasDvd> result = new ArrayList<PanierHasDvd>();
		List<?> resultRaw = req.getResultList();
		Iterator <?> it = resultRaw.iterator();
		while (it.hasNext()) {
			PanierHasDvd obj = (PanierHasDvd) it.next();
			if(email.equals(obj.getId().getPanierId())){
				result.add(obj);
			}			
		}
		

		Iterator <PanierHasDvd> it2 = result.iterator();
		while (it2.hasNext()) {
			int dvdId = it2.next().getId().getDvdId();
			Dvd d = em.find(Dvd.class, dvdId);
			liste.add(d);
		}
		return liste;
		}
	}
	

	@Override
	public void Ajout_Dvd(Panier p, Dvd d) {
		PanierHasDvdPK panDvdPK = new PanierHasDvdPK();
		panDvdPK.setPanierId(p.getEmail());
		panDvdPK.setDvdId(d.getId()); 
		PanierHasDvd panDvd = new PanierHasDvd();
		panDvd.setId(panDvdPK);
		em.persist(panDvd);
	}

	@Override
	public void Supprimer_Dvd(PanierHasDvdPK p, Dvd d) {
		int id = p.getDvdId();
		if (id == d.getId()){
				em.remove(d);
			}
	}

	@Override
	public void Fixer_quantite(PanierHasDvdPK p ,Dvd d, int quantite) {
		int id = p.getDvdId();
		Panier panier = em.find(Panier.class, p.getPanierId());
		if (id == d.getId()){
			panier.setNbProduits(quantite);
		}
		em.persist(p);

	}
	
	@Override 
	public void Somme_totale(){
		List <Dvd> dvds = this.Consulter_Panier();
		Iterator <Dvd> it = dvds.iterator();
		BigDecimal somme = new BigDecimal(0);
		while (it.hasNext()) {
			Dvd d = it.next();
			somme.add(d.getPrix());
		}
		
	}

    /*
	@Override
	public int addPanier() {
		Panier p = new Panier();
		em.merge(p);
		return p.getId();
	}*/
	
	
	@Override
	public void addPanier(String email) {
		Panier p = new Panier(email);
		em.merge(p);
	}
	 

	
}
