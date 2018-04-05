package reseau;

import core.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe permettant de communiquer avec la BDD, n'a pas à etre instanciée
 * @author Louis Triboulin & Fatoumata Bintou Ka
 * @created April 2, 2018
 */

public class LienBDD {
	static final String bddURL = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String bddUser = "SYSTEM";
	static final String bddMdp = "1234";
	
	
	//-------------------------------------------------------------------Fonctions Globales------------------------------------------------------------
	/**
	 * Fonction de contact de la BDD
	 * @param msg : requete SQL
	 * @param type : mise en forme souhaitée en sortie : 
	 * 		0:Personne  
	 * 		1:Lieu  
	 * 		2:Badge     
	 * 		3:Int (pour les requetes count et max)
	 * 		4:néant      
	 * 		5:String (formaté pour le reporting)
	 * @return résultat de la requete sous forme d'une ArrayList
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static private ArrayList askDB(String msg,int type) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList retour = new ArrayList();
		// Contact de la BDD
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con = DriverManager.getConnection(bddURL,bddUser,bddMdp);
		    ps = con.prepareStatement(msg);
		    rs = ps.executeQuery();
		}catch(Exception e){
		   e.printStackTrace();
		}
		System.out.println("REQUETE: " + msg);
		
		// Mise en forme de la réponse
		if(rs!=null) {
			System.out.println("REPONSE OK ");
			
			try {
				retour.clear();
				switch(type) {
				default:while(rs.next()) {		//met des personnes dans la sortie
						Personne p = new Personne();
						p.setId(rs.getInt("ID"));
						p.setNom(rs.getString("NOM"));
						p.setPrenom(rs.getString("PRENOM"));
						p.setNaissance(rs.getString("DATE_DE_NAISSANCE"));
						p.setFonction(rs.getString("FONCTION"));
						retour.add(p);
					}
					break;
				case 1:while(rs.next()) {		//met des lieux dans la sortie
					Lieu l = new Lieu();
					l.setId(rs.getInt("ID"));
					l.setEmplacement(rs.getString("EMPLACEMENT"));
					l.setHoraires(rs.getString("HORAIRE"));
					l.setBloque(rs.getInt("BLOQUE"));
					l.setNbAcces(rs.getInt("NB_ACCES"));
					retour.add(l);
				}
					break;
				case 2:while(rs.next()) {		//met des badges dans la sortie
					Badge b = new Badge();
					b.setId(rs.getInt("ID"));
					b.setProprietaireId(rs.getInt("PROPRIETAIRE"));
					b.setBloque(rs.getInt("BLOQUE"));
					retour.add(b);
				}
					break;
				case 3:while(rs.next()) {		//met des int dans la sortie (de la valeur de l'id à charger)
					Integer i = 0;
					i = rs.getInt("MAX(ID)")+1;
					retour.add(i);
				}
					break;
				case 4://do nothing
					break;
				case 5:while(rs.next()) {		//met des Strings dans la sortie (pour le reporting)
					String s = new String( " " + rs.getInt("ID") +" | "+  (rs.getString("DATE_ENTREE")).substring(0, 10) +" | "+ rs.getString("CONTENU"));
					retour.add(s);
				}
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//fermeture de la connexion a la BDD
		   if(con!=null){
				try{
					ps.close();
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}else
			System.out.println("PAS DE REPONSE DU SERVEUR");
		return retour;
	}
	/**
	 * Fonction permettant de générer un identifiant unique en demandant a la BDD l'id maximal + 1
	 * 		@param type: 0>Personne	1>Lieu	2>Badge  3>report
	 * 		@return : Id généré
	 */
	static private int askNewId(int type) {
		try {
			switch(type) {
				case 0: return (Integer)(askDB("SELECT MAX(ID) FROM PERSONNES",3).get(0));
				case 1: return (Integer)(askDB("SELECT MAX(ID) FROM LIEUX",3).get(0));		
				case 2: return (Integer)(askDB("SELECT MAX(ID) FROM BADGES",3).get(0));		
				case 3: return (Integer)(askDB("SELECT MAX(ID) FROM REPORT",3).get(0));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Fonction MaJ du reporting
	 * 		@param entry : entrée à insérer dans le reporting
	 *      @return néant
	 */
	static private void reportAdd(String entry) {
		int id = askNewId(3);
		try {
			askDB("INSERT INTO REPORT(ID,DATE_ENTREE,CONTENU) VALUES (" + id + ",TRUNC(SYSDATE),'" + entry + "')",4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// --------------------------------------------------------------------------------Personnes-------------------------------------------------------------------------------
	/**
	 * Fonction permettant trouver une personne à partir de son ID
	 * 		@param id :  id de la personne à trouver
	 * 		@return Personne trouvée ou null si non trouvé
	 */
	static public Personne findPersfromID(int id) {
			Personne s = null;
			@SuppressWarnings("unchecked")
			ArrayList<Personne> tmp = askDB("SELECT * FROM PERSONNES WHERE ID = " + id,0);
			if(tmp.size() > 0)
				s = tmp.get(0);
			return s;
	}

	/**
	 * Fonction permettant lister les personnes
	 * 		@param recherche :  critère de recherche
	 * 		@return ArrayList de personnes correspondant aux critères de recherche 
	 */
	@SuppressWarnings("unchecked")
	static public ArrayList<Personne> listPers(String recherche) {
		ArrayList<Personne> s;
		if(recherche.length() == 0)
			s = askDB(  "SELECT * FROM PERSONNES",0); 
		else
			s = askDB(  "SELECT * FROM PERSONNES WHERE NOM LIKE '%" + recherche +"%' OR PRENOM LIKE '%" + recherche +"%' ",0); 
		return s;
	}

	/**
	 * Fonction permettant d'ajouter une personne à la table PERSONNES prenant en entré les caractéristiques de cette Personne (sauf l'ID)
	 * @param nom
	 * @param prenom
	 * @param naissance
	 * @param fonction
	 * @return  1 si réussite sinon 0
	 */
	static public int addPers(String nom,String prenom,String naissance,String fonction) {
		int s = 0;
		int id = askNewId(0);
		try {
			askDB(  "INSERT INTO PERSONNES(ID,NOM,PRENOM,DATE_DE_NAISSANCE,FONCTION) VALUES ("+id+",'"+nom+"','"+prenom+"','"+naissance+"','"+fonction+"')",4);
			s = 1;
			reportAdd("Ajouté à PERSONNES : " + id + " " +  nom + " " +  prenom + " " +  naissance + " " +  fonction);
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	
	/**
	 * Fonction permettant de modifier une personne à la table PERSONNES prenant en entré les caractéristiques de cette Personne
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param naissance
	 * @param fonction
	 * @return 1 si réussite sinon 0
	 */
	static public int updatePers(int id,String nom,String prenom,String naissance,String fonction) {
		int s = 0;
		try {
			askDB("UPDATE PERSONNES SET NOM='"+nom+"',PRENOM='"+prenom+"',DATE_DE_NAISSANCE=TO_DATE('"+naissance+"','yyyy-mm-dd')"+",FONCTION='"+fonction+"' WHERE ID="+id,4);
			s = 1;
			reportAdd("MaJ dans PERSONNES : " + id + " " +  nom + " " +  prenom + " " +  naissance + " " +  fonction);
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	
	/**
	 * Fonction permettant de supprimer une personne de la table PERSONNES
	 * @param id : ID de la personne à supprimer
	 * @return 1 si réussite sinon 0
	 */
	static public int suppPers(int id) {
		int s = 0;
		Personne p = findPersfromID(id);
		try {
			askDB("DELETE FROM PERSONNES WHERE ID="+id+" ",4);
			s = 1;
			reportAdd("Supprimé de PERSONNES : " + id + " " + p.getNom() + " " +  p.getPrenom() );
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	// --------------------------------------------------------------------------------Lieux-------------------------------------------------------------------------------
	/**
	 * Fonction permettant trouver un Lieu à partir de son ID
	 * 		@param id : ID du Lieu à trouver
	 * 		@return Lieu trouvée ou null si non trouvé
	 */
	static public String findLieufromID(int id) {
		String s = "";
		//TODO
		return s;
	}

	/**
	 * Fonction permettant lister les Lieux
	 * 		@param recherche :  critère de recherche
	 * 		@return ArrayList de Lieux correspondant aux critères de recherche 
	 */
	static public ArrayList<Lieu> listLieu(String recherche) {
		ArrayList<Lieu> s = new ArrayList<Lieu>();
		//TODO
		return s;
	}

	/**
	 * Fonction permettant d'ajouter un lieu à la table LIEUX à partir des champs permétants de créer un lieu
	 * @param Emplacement
	 * @param nbAcces
	 * @param Horaires
	 * @param bloque
	 * @return 1 si réussite sinon 0
	 */
	static public int addLieu(String Emplacement, int nbAcces, String Horaires, int bloque) {
		int s = 0;
		//TODO
		return s;
	}

	/**
	 * Fonction permettant de modifier un lieu à la table LIEUX à partir des champs permétants de créer un lieu
	 * @param id
	 * @param Emplacement
	 * @param nbAcces
	 * @param Horaires
	 * @param bloque
	 * @return 1 si réussite sinon 0
	 */
	static public int updateLieu() {
		int s = 0;
		//TODO
		return s;
	}

	/**
	 * Fonction permettant de supprimer un lieu de la table LIEUX
	 * 		@param id : ID du lieu à supprimer
	 * 		@return 1 si réussite sinon 0
	 */
	static public int suppLieu(int id) {
		int s = 0;
		//TODO
		return s;
	}


	// --------------------------------------------------------------------------------Badges-------------------------------------------------------------------------------
	/**
	 * Fonction permettant trouver un badge à partir de son ID
	 * 		@param id : ID du Badge à trouver
	 * 		@return Badge trouvée ou null si non trouvé
	 */
	static public Badge findBadgefromID(int id) {
		@SuppressWarnings("unchecked")
		ArrayList<Badge> tmp = askDB("SELECT * FROM BADGES WHERE ID = " + id,2);
		Badge s = tmp.get(0);
		return s;
	}
	static public ArrayList<Badge> findBadgefromOwner(int id){
		@SuppressWarnings("unchecked")
		ArrayList<Badge> s = askDB("SELECT * FROM BADGES WHERE PROPRIETAIRE = " + id,2);
		return s;
	}

	/**
	 * Fonction permettant lister les badge
	 * 		@param recherche :  critère de recherche
	 * 		@return ArrayList de badge correspondant aux critères de recherche 
	 */
	@SuppressWarnings("unchecked")
	static public ArrayList<Badge> listBadge(String recherche) {
		ArrayList<Badge> s = new ArrayList<Badge>();
		ArrayList<Badge> tmp = null;
		if(recherche.length() == 0) {
			tmp = askDB(  "SELECT * FROM BADGES",2); 
		}else if(recherche.matches("-?\\d+(\\.\\d+)?")) {//test si la recherche est un nombre
			tmp = askDB(  "SELECT * FROM BADGES WHERE PROPRIETAIRE = " + Integer.valueOf(recherche) + " OR ID = " + Integer.valueOf(recherche),2); 
		}else{
			int propId;
			ArrayList<Personne> pLst = listPers(recherche);
			for(int i = 0; i<pLst.size();i++) {
				propId = pLst.get(i).getId();
				tmp = askDB(  "SELECT * FROM BADGES WHERE PROPRIETAIRE = " + propId,2);
			}
		}
		if(tmp!=null)
		for(int j = 0; j<tmp.size();j++) {
			Personne owner = LienBDD.findPersfromID(tmp.get(j).getProprietaireId());
			if(owner!=null)
				tmp.get(j).setProprietaireFullName( owner.getNom()+ " " +  owner.getPrenom());
			else
				tmp.get(j).setProprietaireFullName("[Erreur:Propriétaire inexistant]");
			s.add(tmp.get(j));
		}
		return s;
	}

	/**
	 * Fonction permettant d'ajouter un badge à la table BADGES à partir des champs permétants de créer un badge
	 * @param idaff
	 * @param bloque
	 * @return 1 si réussite sinon 0
	 */
	static public int addBadge(int idaff, int bloque) {
		int s = 0;
		int id = askNewId(2);
		try {
			askDB(  "INSERT INTO BADGES(ID,PROPRIETAIRE,BLOQUE) VALUES ("+id+",'"+idaff+"','"+bloque+"')",4);
			s = 1;
			reportAdd("Ajouté à BADGES : " + id + " " +  idaff + " B" +  bloque);
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	/**
	 * Fonction permettant de modifier un badge dans la table BADGES
	 * @param id
	 * @param idaff
	 * @param bloque
	 * @return 1 si réussite sinon 0
	 */
	static public int updateBadge(int id,int idaff, int bloque) {
		int s = 0;
		try {
			askDB("UPDATE BADGES SET PROPRIETAIRE='"+idaff+"',BLOQUE='"+bloque+"' WHERE ID="+id,4);
			s = 1;
			reportAdd("MaJ dans BADGES : " + id + " " +  idaff + " B" +  bloque);
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	/**
	 * Fonction permettant de supprimer un badge de la table BADGES à partir de son id
	 * @param id du badge
	 * @return 1 si réussite sinon 0
	 */
	static public int suppBadge(int id) {
		int s = 0;
		Badge b = findBadgefromID(id);
		try {
			askDB("DELETE FROM BADGES WHERE ID="+id+" ",4);
			s = 1;
			reportAdd("Supprimé de BADGES : ID_" + id + " P" + b.getProprietaireId() + " B" +  b.getBloque() );
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}

	/**
	 * Fonction permettant de supprimer un badge de la table BADGES à partir de l'id de la personne associée
	 * @param id de la personne associée
	 * @return 1 si réussite sinon 0
	 */
	static public int suppBadgeFromOwner(int id) {
		int s = 0;
		ArrayList<Badge> bList = findBadgefromOwner(id);
		try {
			for(int i = 0;i<bList.size();i++) {
				askDB("DELETE FROM BADGES WHERE PROPRIETAIRE="+id+" ",4);
				s = 1;
				reportAdd("Supprimé de BADGES : ID_" + id + " P" + bList.get(i).getProprietaireId() + " B" +  bList.get(i).getBloque() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			s = 0;
		}
		return s;
	}
	// --------------------------------------------------------------------------------Reporting-------------------------------------------------------------------------------
		/**
		 * Fonction de lecture du reporting
		 * 		@return Arraylist des entrées du reporting
		 */
		@SuppressWarnings("unchecked")
		static public ArrayList<String> readReporting() {
			ArrayList<String> s = askDB("SELECT * FROM REPORT",5);
			return s;
		}


}
