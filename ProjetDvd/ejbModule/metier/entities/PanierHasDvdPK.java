package metier.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the panier_has_dvd database table.
 * 
 */
@Embeddable
public class PanierHasDvdPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="panier_id", insertable=false, updatable=false)
	private String panierId;

	@Column(name="dvd_id", insertable=false, updatable=false)
	private int dvdId;

	public PanierHasDvdPK() {
	}
	public String getPanierId() {
		return this.panierId;
	}
	public void setPanierId(String panierId) {
		this.panierId = panierId;
	}
	public int getDvdId() {
		return this.dvdId;
	}
	public void setDvdId(int dvdId) {
		this.dvdId = dvdId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PanierHasDvdPK)) {
			return false;
		}
		PanierHasDvdPK castOther = (PanierHasDvdPK)other;
		return 
			(this.panierId == castOther.panierId)
			&& (this.dvdId == castOther.dvdId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.panierId.hashCode();
		hash = hash * prime + this.dvdId;
		
		return hash;
	}
}