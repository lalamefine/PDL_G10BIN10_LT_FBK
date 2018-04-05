package core;

/**
 * Classe permettant de stocker les caractéristiques d'un badge
 * @author Louis Triboulin & Fatoumata Bintou Ka
 * @created April 2, 2018
 */
public class Badge {
	
	/**
	 * Constructeur
	 * @param id
	 * @param proprietaireId
	 * @param bloque
	 */
	public Badge(int id, int proprietaireId, int bloque) {
		this.id = id;
		this.proprietaireId = proprietaireId;
		this.bloque = bloque;
	}
	
	/**
	 * Constructeur
	 */
	public Badge() {}
	
	
	private int id;
	private int proprietaireId;
	private String proprietaireFullName;
	private int bloque;
	
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
	 * @return proprietaireFullName
	 */
	public String getProprietaireFullName() {
		return proprietaireFullName;
	}
	
	/**
	 * @param proprietaireFullName
	 */
	public void setProprietaireFullName(String proprietaireFullName) {
		this.proprietaireFullName = proprietaireFullName;
	}
	
	/**
	 * @returnid
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
	 * @return proprietaireId
	 */
	public int getProprietaireId() {
		return proprietaireId;
	}
	
	/**
	 * @param proprietaireId
	 */
	public void setProprietaireId(int proprietaireId) {
		this.proprietaireId = proprietaireId;
	}

}
