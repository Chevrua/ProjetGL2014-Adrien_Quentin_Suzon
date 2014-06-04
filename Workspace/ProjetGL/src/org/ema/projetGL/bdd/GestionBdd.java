package org.ema.projectGL.bdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.ema.projectGL.ihm.FenetreAccueil;

public class GestionBdd {
	private Connection conn;
	
	public GestionBdd() throws Exception {
		
		  try {
			Class.forName("org.postgresql.Driver");	      	         
			String url = "jdbc:postgresql://localhost:5432/Projet";
		    String user = "postgres";
		    String passwd = "admin";
		         
		      this.conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}  
	}
	
	public static void main(String[] args){
	    FenetreAccueil test = new FenetreAccueil();
	}   
	public Connection getConnection(){
		return this.conn;
	}
	
	  
	//-------------------Méthode qui teste si un nom est bien dans la table eleve--------------------------------------
	
		public String EstEleve(String login) throws ClassNotFoundException, SQLException{			
			  String res;			
			  Statement state0 = this.conn.createStatement();
		      ResultSet result0 = state0.executeQuery("SELECT COUNT(*) FROM Eleves where login = '"+login+"'");
		      result0.next();
		      if (result0.getInt(1) > 0 ){
		    	  res= login;
		      }
		      else{
		    	  res= " Bizarre je ne connais pas cet eleve ! ";
		      }   
			return res;
		}
		
		public String EstProf(String login) throws ClassNotFoundException, SQLException{			
			  String res;			
			  Statement state0 = this.conn.createStatement();
		      ResultSet result0 = state0.executeQuery("SELECT COUNT(*) FROM Professeur where login = '"+login+"'");
		      result0.next();
		      if (result0.getInt(1) > 0 ){
		    	  res= login;
		      }
		      else{
		    	  res= " Bizarre je ne connais pas ce professeur ! ";		    	  
		      }
		      
			return res;
		}
		
//		public String GetClassName(String login) throws Exception{
//		
//			Statement state0 = this.conn.createStatement();
//			ResultSet result0 = state0.executeQuery("SELECT cls_nom FROM classe,eleve WHERE classe.cls_id = eleve.elv_cls_k AND elv_nom = '"+login+"'");
//			result0.next();
//			String res = (String) result0.getObject(1);
//			System.out.println(res);
//			
//			return res;
//		
//		}
//		
//		public String GetListMatiere(String login) throws Exception{
//			
//			Statement state0 = this.conn.createStatement();
//			ResultSet result0 = state0.executeQuery("SELECT mat_nom FROM matiere");
//			result0.next();
//			String res ="";
//			
//			return res;
//		}
//		
		
}




