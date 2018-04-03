package reseau;

import java.sql.*;

public class LienBDD {
	String bddURL = "jdbc:oracle:thin:@localhost:1521:bdd";
	String bddUser = "SYSTEM";
	String bddMdp = "1234";
	
	
	public LienBDD(){}
	
	public ResultSet askDB(String msg) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet retour = null;
		try{
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
	
	


}
