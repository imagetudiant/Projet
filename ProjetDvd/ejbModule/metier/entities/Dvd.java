package metier.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Dvd
 *
 */
@Entity

public class Dvd implements Serializable {

	   
	@Id
	private Integer code;
	private String titre;
	private Long prix;
	private Integer quantiteEnStock;
	private Date date;
	private String categorie;
	private static final long serialVersionUID = 1L;

	public Dvd() {
		super();
	}   
	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}   
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}   
	public Long getPrix() {
		return this.prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}   
	public Integer getQuantiteEnStock() {
		return this.quantiteEnStock;
	}

	public void setQuantiteEnStock(Integer quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
   
}
