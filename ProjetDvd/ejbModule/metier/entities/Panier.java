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


	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private int id;

	@Column(name="nb_produits")
	private int nbProduits;
	
	@Id
	@Column(name="client_email")
	private String email;
	

	public Panier() {
		nbProduits = 0;
	}
	
	public Panier(String email) {
		this.email = email;
	}
	
	

	/*public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
*/
	public int getNbProduits() {
		return this.nbProduits;
	}

	public void setNbProduits(int nbProduits) {
		this.nbProduits = nbProduits;
	}
	
	
	public String getemail() {
		return this.email;
	}

	public void setClientId(String email) {
		this.email = email;
	}
	

}