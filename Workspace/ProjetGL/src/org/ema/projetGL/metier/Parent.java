package org.ema.projectGL.metier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class Parent extends Personne{
	protected Vector<Eleves> enfants;
	
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
	Connection conn = DriverManager.getConnection("jdbc:mysql:///MaBD");
	Statement stmt = conn.createStatement();
	stmt.executeUpdate("INSERT INTO table Parent ("+this.mdp+"','"+this.nom+"','"+this.prenom+"')"); 
	
// Vérifier la prééxistance de la variable dans la BDD
}
}
