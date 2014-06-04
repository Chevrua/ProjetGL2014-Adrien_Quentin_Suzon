package org.ema.projectGL.bdd;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LiaisonBDD {

	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // Charger le driver	
		}

		catch (Exception e){e.printStackTrace();}

		// A mettre dans une classe utilitaire
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql:///MaBD"); // MaBD permet le choix de la BDD
			Statement stmt = conn.createStatement(); // Pour des requetes ponctuelles
			stmt.executeUpdate("create database MaBD");  // Retourne un entier (Nombre de tuples affectés)
			stmt.executeUpdate("use MaBD"); 
			stmt.executeQuery("import * from MaBD"); // Retourne des données

			stmt.executeUpdate("create table ouvrage (id integer primary key, titre char(100) not null, nb_exemplaire integer not null)"); 
			// On peut mettre des variables comme avec un println dans l'executeUpdate, on peut aussi utiliser des accesseurs comme toString ...

			// Attention la numérotation des paramètres commence à un 
			ResultSet res = stmt.executeQuery("select nom, nb_emprunts from abonne where nb_emprunts > 3");

			// La lecture entraine des verrous en écriture mais pas en lecture
			PreparedStatement stat = conn.prepareStatement("select * from abonne where nom = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			conn.commit(); // conn.setAutoCommit(true); possible, il est actif de base, on peut le désactiver avec false
		}
		catch(SQLException e)
		{
			System.out.println("sql exception");
		while(e!=null)
		{
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
			e.printStackTrace();
			e=e.getNextException();
		}
		}



	}

}*/
