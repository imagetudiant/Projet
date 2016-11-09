package service;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import metier.DvdLocal;
import metier.entities.Dvd;

@WebService
public class DvdService {

	@EJB
	private DvdLocal metier;

	public Dvd getDvd(int id) {
		return metier.getDvd(id);
	}

	public List<Dvd> searchDvd(String titreRech) {
		return metier.searchDvd(titreRech);
	}

	public List<Dvd> listDvd() {
		return metier.listDvd();
	}

	public void editDvd(int id, String titre, double prix) {
		metier.editDvd(id, titre, prix);
	}
}
