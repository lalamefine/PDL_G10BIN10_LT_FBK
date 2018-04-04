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
	 * 		Entrée : requete SQL 
	 * 		Sortie : résultat de la requete
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
		System.out.println("REQUETE: " + msg);
		if(retour!=null)
			System.out.println("REPONSE: " + retour.toString());  // ATTENTION , verifier si ceci clear le resultset
		else
			System.out.println("PAS DE REPONSE DU SERVEUR ");
		return retour;
	}
	/*
	 * Fonction permettant de générer un identifiant unique en demandant a la BDD l'id maximal + 1
	 * 		Entrée :		0>Personne	1>Lieu	2>Badge  3>report
	 * 		Sortie : Id généré
	 */
	private int askNewId(int type) {
		ResultSet rs;
		try {
			switch(type) {
			case 0: rs = askDB("SELECT MAX(ID) FROM PERSONNES");
				return rs.getInt(1);
			case 1: rs = askDB("SELECT MAX(ID) FROM LIEUX");
				return rs.getInt(1);
			case 2: rs = askDB("SELECT MAX(ID) FROM BADGES");
				return rs.getInt(1);
			case 3: rs = askDB("SELECT MAX(ID) FROM REPORT");
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * Fonction MaJ du reporting
	 * 		Entrée : entrée à insérer dans le reporting
	 * 		Sortie : néant
	 */
	private void reportAdd(String entry) {
		int id = askNewId(3);
		try {
			askDB(  "INSERT INTO REPORT(ID,DATE_ENTREE,CONTENU) VALUES (" + id + ",NOW(),'" + entry + "');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// --------------------------------------------------------------------------------Personnes-------------------------------------------------------------------------------
	/*
	 * Fonction permettant trouver une personne à partir de son ID
	 * 		Entrée :  id de la personne à trouver
	 * 		Sortie : Personne trouvée ou null si non trouvé
	 */
	public Personne findPersfromID(int id) {
		Personne s = new Personne();
		ResultSet rs;
		try {
			rs = askDB("SELECT * FROM PERSONNES WHERE ID=" + id+";");
			 s.setId(rs.getInt(1));
			 s.setNom(rs.getString(2));
			 s.setPrenom(rs.getString(3));
			 s.setNaissance(rs.getString(4));
			 s.setFonction(rs.getString(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/*
	 * Fonction permettant lister les personnes
	 * 		Entrée :  critère de recherche
	 * 		Sortie :  ArrayList de personnes correspondant aux critères de recherche 
	 */
	public ArrayList<Personne> listPers(String recherche) {
		ArrayList<Personne> s = new ArrayList<Personne>();
		ResultSet rs;
		try {
			rs = askDB(  "SELECT * FROM PERSONNES WHERE (NOM LIKE %" + recherche +"% ) OR (PRENOM LIKE %" + recherche +"% );"  );
			while(rs.next()) {
				Personne p = new Personne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				s.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/*
	 * Fonction permettant d'ajouter une personne à la table PERSONNES
	 * 		Entrée :  champs permétant de créer une personne
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int addPers(String nom,String prenom,String naissance,String fonction) {
		int s = 0;
		int id = askNewId(0);

		try {
			askDB(  "INSERT INTO PERSONNES(ID,NOM,PRENOM,DATE_DE_NAISSANCE,FONCTION) VALUES ("+id+","+nom+","+prenom+","+naissance+","+fonction+");");
			s = 1;
			reportAdd("Ajouté à PERSONNES :" + id + " " +  nom + " " +  prenom + " " +  naissance + " " +  fonction);
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	/*
	 * Fonction permettant de modifier une personne à la table PERSONNES
	 * 		Entrée :  id + champs permétant de créer une personne
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int updatePers(int id,String nom,String prenom,String naissance,String fonction) {
		int s = 0;
		try {
			askDB("UPDATE PERSONNES SET NOM="+nom+",PRENOM="+prenom+",DATE_DE_NAISSANCE="+naissance+",FONCTION="+fonction+" WHERE ID="+id+" ;");
			s = 1;
			reportAdd("MaJ dans PERSONNES :" + id + " " +  nom + " " +  prenom + " " +  naissance + " " +  fonction);
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	/*
	 * Fonction permettant de supprimer une personne de la table PERSONNES
	 * 		Entrée :  id
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int suppPers(int id) {
		int s = 0;
		Personne p = findPersfromID(id);
		try {
			askDB("DELETE FROM PERSONNES WHERE ID="+id+" ;");
			s = 1;
			reportAdd("Supprimé de PERSONNES :" + id + " " + p.getNom() + " " +  p.getPrenom() );
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	// --------------------------------------------------------------------------------Lieux-------------------------------------------------------------------------------
	/*
	 * Fonction permettant trouver un lieu à partir de son ID
	 * 		Entrée :  id de la personne à trouver
	 * 		Sortie : Personne trouvée ou null si non trouvé
	 */
	public String findLieufromID(int id) {
		String s = "";
		//TODO
		return s;
	}

	/*
	 * Fonction permettant lister les lieu
	 * 		Entrée :  critère de recherche
	 * 		Sortie :  ArrayList de lieu correspondant aux critères de recherche 
	 */
	public ArrayList<Lieu> listLieu(String recherche) {
		ArrayList<Lieu> s = new ArrayList<Lieu>();
		//TODO
		
		return s;
	}

	/*
	 * Fonction permettant d'ajouter un lieu à la table LIEUX
	 * 		Entrée :  champs permétant de créer un lieu
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int addLieu() {
		int s = 0;
		//TODO
		return s;
	}

	/*
	 * Fonction permettant de modifier un lieu à la table LIEUX
	 * 		Entrée :  id + champs permétant de créer un lieu
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int updateLieu() {
		int s = 0;
		//TODO
		return s;
	}

	/*
	 * Fonction permettant de supprimer un lieu de la table LIEUX
	 * 		Entrée :  id
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int suppLieu(int id) {
		int s = 0;
		//TODO
		return s;
	}


	// --------------------------------------------------------------------------------Badges-------------------------------------------------------------------------------
	/*
	 * Fonction permettant trouver un badge à partir de son ID
	 * 		Entrée :  id de la personne à trouver
	 * 		Sortie : Personne trouvée ou null si non trouvé
	 */
	public String findBadgefromID(int id) {
		String s = "";
		//TODO
		return s;
	}

	/*
	 * Fonction permettant lister les badge
	 * 		Entrée :  critère de recherche
	 * 		Sortie :  ArrayList de badge correspondant aux critères de recherche 
	 */
	public ArrayList<Badge> listBadge(String recherche) {
		ArrayList<Badge> s = new ArrayList<Badge>();
		
		//TODO
		return s;
	}

	/*
	 * Fonction permettant d'ajouter un badge à la table BADGES
	 * 		Entrée :  champs permétant de créer un badge
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int addBadge() {
		int s = 0;
		//TODO
		return s;
	}

	/*
	 * Fonction permettant de modifier un badge à la table BADGES
	 * 		Entrée :  id + champs permétant de créer un badge
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int updateBadge() {
		int s = 0;
		//TODO
		return s;
	}

	/*
	 * Fonction permettant de supprimer un badge de la table BADGES
	 * 		Entrée :  id
	 * 		Sortie :  1 si réussite sinon 0
	 */
	public int suppBadge(int id) {
		int s = 0;
		//TODO
		return s;
	}
	
	


}
