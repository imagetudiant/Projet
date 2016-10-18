package metier.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the panier_has_dvd database table.
 * Symbolizes the many-to-many relation between Panier and Dvd.
 * 
 */
@Entity
@Table(name="panier_has_dvd")
@NamedQuery(name="PanierHasDvd.findAll", query="SELECT p FROM PanierHasDvd p")
public class PanierHasDvd implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PanierHasDvdPK id;

	public PanierHasDvd() {
	}

	public PanierHasDvdPK getId() {
		return this.id;
	}

	public void setId(PanierHasDvdPK id) {
		this.id = id;
	}

}