package core;

public class Lieu {
	private int id;
	private String emplacement;
	private int nbAcces;
	private String horraires;
	private int bloque;

	public Lieu(int id, String emplacement, int nbAcces, String horraires, int bloque) {
		this.id = id;
		this.emplacement = emplacement;
		this.nbAcces = nbAcces;
		this.horraires = horraires;
		this.bloque = bloque;
	}
	public Lieu() {}
	
	public int getBloque() {
		return bloque;
	}
	public void setBloque(int bloque) {
		this.bloque = bloque;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public int getNbAcces() {
		return nbAcces;
	}
	public void setNbAcces(int nbAcces) {
		this.nbAcces = nbAcces;
	}
	public String getHorraires() {
		return horraires;
	}
	public void setHorraires(String horraires) {
		this.horraires = horraires;
	}
}
