package metier;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Dvd;

@Remote
public interface DvdRemote {
	public Dvd searchDvd(int id);
	public List<Dvd> listDvd();
	public void editDvd(int id, String titre, double prix);
	
}
