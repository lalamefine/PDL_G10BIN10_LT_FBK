package core;

/**
 * Classe permettant de stocker les caractéristiques d'un lieu de manières organisée
 * @author Louis Triboulin & Fatoumata Bintou Ka
 * @created April 2, 2018
 */
public class Lieu {
	private int id;
	private String emplacement;
	private int nbAcces;
	private String horaires;
	private int bloque;

	/**
	 * Constructeur
	 * @param id
	 * @param emplacement
	 * @param nbAcces
	 * @param horaires
	 * @param bloque
	 */
	public Lieu(int id, String emplacement, int nbAcces, String horaires, int bloque) {
		this.id = id;
		this.emplacement = emplacement;
		this.nbAcces = nbAcces;
		this.horaires = horaires;
		this.bloque = bloque;
	}
	
	/**
	 * Constructeur
	 */
	public Lieu() {}
	
	/**
	 * @return bloque
	 */
	public int getBloque() {
		return bloque;
	}
	
	/**
	 * @param bloque
	 */
	public void setBloque(int bloque) {
		this.bloque = bloque;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return emplacement
	 */
	public String getEmplacement() {
		return emplacement;
	}
	/**
	 * @param emplacement
	 */
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	/**
	 * @return nbAcces
	 */
	public int getNbAcces() {
		return nbAcces;
	}
	/**
	 * @param nbAcces
	 */
	public void setNbAcces(int nbAcces) {
		this.nbAcces = nbAcces;
	}
	/**
	 * @return horaires
	 */
	public String getHoraires() {
		return horaires;
	}
	/**
	 * @param horaires
	 */
	public void setHoraires(String horaires) {
		this.horaires = horaires;
	}
}
