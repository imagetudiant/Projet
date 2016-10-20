package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Dvd;

@Local
public interface DvdLocal {
	public Dvd searchDvd(int id);
	public List<Dvd> listDvd();
	public void editDvd(int id, String titre, double prix);
	

}
