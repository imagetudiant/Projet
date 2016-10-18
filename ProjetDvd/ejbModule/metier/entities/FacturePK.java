package metier.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the facture database table.
 * Exists because a facture needs a panier to exist.
 */
@Embeddable
public class FacturePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="panier_id", insertable=false, updatable=false)
	private int panierId;

	public FacturePK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPanierId() {
		return this.panierId;
	}
	public void setPanierId(int panierId) {
		this.panierId = panierId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FacturePK)) {
			return false;
		}
		FacturePK castOther = (FacturePK)other;
		return 
			(this.id == castOther.id)
			&& (this.panierId == castOther.panierId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.panierId;
		
		return hash;
	}
}