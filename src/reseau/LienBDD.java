package reseau;

import core.*;
import java.sql.*;
import java.util.ArrayList;

public class LienBDD {
	//String bddURL = "jdbc:mysql://192.168.1.41:3306/PDL"; // for mysql
	String bddURL = "jdbc:oracle:thin:@localhost:1521:bdd"; // for oracle
	String bddUser = "SYSTEM";
	String bddMdp = "1234";
	
	
	
	 // 	-----------------------Fonctions---------------------------------------
	/*
	 * Fonction de contact de la BDD
	 * 		Entr�e : requete SQL 
	 * 		Sortie : r�sultat de la requete
	 */
	private ResultSet askDB(String msg) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet retour = null;
		try{
			//Class.forName("com.mysql.jdbc.Driver");   //for mysql
			Class.forName("oracle.jdbc.driver.OracleDriver"); //for oracle
		   con = DriverManager.getConnection(bddURL,bddUser,bddMdp);
		   ps = con.prepareStatement(msg);
		   retour = ps.executeQuery();
		}catch(Exception e){
		   System.out.println("Erreur : ");
		   e.printStackTrace();
		}finally{
		   if(con!=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return retour;
	}
	/*
	 * Fonction permettant de g�n�rer un identifiant unique en demandant a la BDD l'id maximal + 1
	 * 		Entr�e :		0>Personne	1>Lieu	2>Badge
	 * 		Sortie : Id g�n�r�
	 */
	private int askNewId(int type) {
		int newid = 0;
		switch(type) {
		case 0://WIP
			break;
		case 1://WIP
			break;
		case 2://WIP
			break;
		}
		return newid;
	}
	
	/*
	 * Fonction MaJ du reporting
	 * 		Entr�e : entr�e � ins�rer dans le reporting
	 * 		Sortie : n�ant
	 */
	private void reportAdd(String entry) {
		
	}
	
	// --------------------------------------------------------------------------------Personnes-------------------------------------------------------------------------------
	/*
	 * Fonction permettant trouver une personne � partir de son ID
	 * 		Entr�e :  id de la personne � trouver
	 * 		Sortie : Personne trouv�e ou null si non trouv�
	 */
	public Personne findPersfromID(int id) {
		Personne s = null;
		ResultSet rs;
		try {
			rs = askDB("SELECT * FROM PERSONNES WHERE ID=" + id);
			 s.setId(rs.getInt(1));
			 s.setNom(rs.getString(2));
			 s.setPrenom(rs.getString(3));
			 s.setNaissance(rs.getString(4));
			 s.setFonction(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	/*
	 * Fonction permettant lister les personnes
	 * 		Entr�e :  crit�re de recherche
	 * 		Sortie :  ArrayList de personnes correspondant aux crit�res de recherche 
	 */
	public ArrayList<Personne> listPers(String recherche) {
		ArrayList<Personne> s = new ArrayList<Personne>();
		ResultSet rs;
		try {
			rs = askDB(  "SELECT * FROM PERSONNES WHERE (NOM LIKE %" + recherche +"% ) OR (PRENOM LIKE %" + recherche +"% )"  );
			while(rs.next()) {
				Personne p = new Personne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				s.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	/*
	 * Fonction permettant d'ajouter une personne � la table PERSONNES
	 * 		Entr�e :  champs perm�tant de cr�er une personne
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int addPers(String nom,String prenom,String naissance,String fonction) {
		int s = 0;
		int id = askNewId(0);

		//TODO
		
		reportAdd("Ajout� � PERSONNES :" + id + " " +  nom + " " +  prenom + " " +  naissance + " " +  fonction);
		return s;
	}

	/*
	 * Fonction permettant de modifier une personne � la table PERSONNES
	 * 		Entr�e :  id + champs perm�tant de cr�er une personne
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int updatePers(int id,String nom,String prenom,String naissance,String fonction) {
		int s = 0;
		//TODO
		reportAdd("MaJ dans PERSONNES :" + id + " " +  nom + " " +  prenom + " " +  naissance + " " +  fonction);
		return s;
	}

	/*
	 * Fonction permettant de supprimer une personne de la table PERSONNES
	 * 		Entr�e :  id
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int suppPers(int id) {
		int s = 0;
		Personne p = findPersfromID(id);
		//TODO
		reportAdd("Supprim� de PERSONNES :" + id + " " + p.getNom() + " " +  p.getPrenom() );
		return s;
	}

	// --------------------------------------------------------------------------------Lieux-------------------------------------------------------------------------------
	/*
	 * Fonction permettant trouver un lieu � partir de son ID
	 * 		Entr�e :  id de la personne � trouver
	 * 		Sortie : Personne trouv�e ou null si non trouv�
	 */
	public String findLieufromID(int id) {
		String s = "";
		//TODO
		return s;
	}

	/*
	 * Fonction permettant lister les lieu
	 * 		Entr�e :  crit�re de recherche
	 * 		Sortie :  ArrayList de lieu correspondant aux crit�res de recherche 
	 */
	public ArrayList<Lieu> listLieu(String recherche) {
		ArrayList<Lieu> s = new ArrayList<Lieu>();
		//TODO
		
		return s;
	}

	/*
	 * Fonction permettant d'ajouter un lieu � la table LIEUX
	 * 		Entr�e :  champs perm�tant de cr�er un lieu
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int addLieu() {
		int s = 0;
		//TODO
		return s;
	}

	/*
	 * Fonction permettant de modifier un lieu � la table LIEUX
	 * 		Entr�e :  id + champs perm�tant de cr�er un lieu
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int updateLieu() {
		int s = 0;
		//TODO
		return s;
	}

	/*
	 * Fonction permettant de supprimer un lieu de la table LIEUX
	 * 		Entr�e :  id
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int suppLieu(int id) {
		int s = 0;
		//TODO
		return s;
	}


	// --------------------------------------------------------------------------------Badges-------------------------------------------------------------------------------
	/*
	 * Fonction permettant trouver un badge � partir de son ID
	 * 		Entr�e :  id de la personne � trouver
	 * 		Sortie : Personne trouv�e ou null si non trouv�
	 */
	public String findBadgefromID(int id) {
		String s = "";
		//TODO
		return s;
	}

	/*
	 * Fonction permettant lister les badge
	 * 		Entr�e :  crit�re de recherche
	 * 		Sortie :  ArrayList de badge correspondant aux crit�res de recherche 
	 */
	public ArrayList<Badge> listBadge(String recherche) {
		ArrayList<Badge> s = new ArrayList<Badge>();
		
		//TODO
		return s;
	}

	/*
	 * Fonction permettant d'ajouter un badge � la table BADGES
	 * 		Entr�e :  champs perm�tant de cr�er un badge
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int addBadge() {
		int s = 0;
		//TODO
		return s;
	}

	/*
	 * Fonction permettant de modifier un badge � la table BADGES
	 * 		Entr�e :  id + champs perm�tant de cr�er un badge
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int updateBadge() {
		int s = 0;
		//TODO
		return s;
	}

	/*
	 * Fonction permettant de supprimer un badge de la table BADGES
	 * 		Entr�e :  id
	 * 		Sortie :  1 si r�ussite sinon 0
	 */
	public int suppBadge(int id) {
		int s = 0;
		//TODO
		return s;
	}
	
	


}
