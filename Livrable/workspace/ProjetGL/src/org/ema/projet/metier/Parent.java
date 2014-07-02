package org.ema.projet.metier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Parent extends Personne{
	
	
//Chaque action doit avoir un impact dans la BDD

public Parent(){
	super();
// création de la personne dans la BDD
}

public Parent (String nom,String prenom, String mdp, String dateNaiss, String adresse, String mail){
	super(nom,prenom,mdp,dateNaiss,adresse,mail);
// création de la personne dans la BDD
}

public void envoie() throws SQLException{
	//Ouverture
	Connection conn = DriverManager.getConnection("jdbc:mysql:///MaBD");
	Statement stmt = conn.createStatement();
	try{
	
	stmt.executeUpdate("INSERT INTO table Parent ("+this.getMdp()+"','"+this.getNom()+"','"+this.getPrenom()+"')"); 
	}
	// Pour fermer correctement
	 finally {
		 conn.close();
		 stmt.close();
			
		}
	
	
	
// Vérifier la prééxistance de la variable dans la BDD
}
}
