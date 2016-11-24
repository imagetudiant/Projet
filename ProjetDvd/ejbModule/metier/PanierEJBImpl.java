package metier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import metier.entities.Dvd;
import metier.entities.Panier;
import metier.entities.PanierHasDvdPK;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="Panier")
public class PanierEJBImpl implements PanierRemote, PanierLocal{

	@PersistenceContext(unitName="ProjetDvd")
	private EntityManager em;
	
	@Override
	public List<PanierHasDvdPK> Consulter_Panier(Panier p) {
		Query req =em.createNamedQuery("PanierHasDvdPK.findAll");
		List<PanierHasDvdPK> result = new ArrayList<PanierHasDvdPK>();
		List<?> resultRaw = req.getResultList();
		Iterator <?> it = resultRaw.iterator();
		while (it.hasNext()) {
			if(p.getId() == ((PanierHasDvdPK) it.next()).getPanierId()){
				result.add((PanierHasDvdPK) it.next());
			}
			
		}
		return result;
	}
	

	@Override
	public void Ajout_Dvd(Panier p, Dvd d) {
		PanierHasDvdPK panier = new PanierHasDvdPK();
		panier.setPanierId(p.getId());
		panier.setDvdId(d.getId());
		em.persist(panier);
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
	public void Somme_totale(Panier p){
		List<PanierHasDvdPK> paniers = this.Consulter_Panier(p);
		Iterator <PanierHasDvdPK> it = paniers.iterator();
		BigDecimal somme = new BigDecimal(0);
		while (it.hasNext()) {
			Dvd d = em.find(Dvd.class,((PanierHasDvdPK) it.next()).getDvdId() );
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
