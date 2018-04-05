package core;

/**
 * Classe permettant de stocker les caractéristiques d'une personnes de manières organisée
 * @author Louis Triboulin & Fatoumata Bintou Ka
 * @created April 2, 2018
 */
public class Personne {
	
	/**
	 * Constructeur
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param naissance
	 * @param fonction
	 */
	public Personne(int id, String nom, String prenom, String naissance, String fonction) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.fonction = fonction;
	}
	
	/**
	 * Constructeur
	 */
	public Personne() {}
	
	private int id;
	private String nom;
	private String prenom;
	private String naissance;
	private String fonction;
	
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
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * @return naissance
	 */
	public String getNaissance() {
		return naissance;
	}
	
	/**
	 * @param naissance
	 */
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	
	/**
	 * @return fonction
	 */
	public String getFonction() {
		return fonction;
	}
	
	/**
	 * @param fonction
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	/**
	 * [DEBUG] Renvoie les caractéristiques d'une personne de la console
	 */
	public void afficher() {
		System.out.println("ID=" + id );
		System.out.println("nom=" + nom );
		System.out.println("prenom="  + prenom );
		System.out.println("naissance=" + naissance );
		System.out.println("Fonction="+ fonction );
	}

}
