package metier.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the panier database table.
 * 
 */
@Entity
@NamedQuery(name="Panier.findAll", query="SELECT p FROM Panier p")
public class Panier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="nb_produits")
	private int nbProduits;

	public Panier() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbProduits() {
		return this.nbProduits;
	}

	public void setNbProduits(int nbProduits) {
		this.nbProduits = nbProduits;
	}

}