package metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the facture database table.
 * 
 */
@Entity
@NamedQuery(name="Facture.findAll", query="SELECT f FROM Facture f")
public class Facture implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FacturePK id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private BigDecimal somme;

	public Facture() {
	}

	public FacturePK getId() {
		return this.id;
	}

	public void setId(FacturePK id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getSomme() {
		return this.somme;
	}

	public void setSomme(BigDecimal somme) {
		this.somme = somme;
	}

}