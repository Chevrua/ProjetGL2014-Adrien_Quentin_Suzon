package org.ema.projetGL.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ema.projetGL.metier.Eleves;

public abstract class ElevesDAO extends DAO<Eleves> {
	  public ElevesDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(Eleves obj) {
	    return false; //pour le moment
	  }
	  public boolean delete(Eleves obj) {
	    return false; //pour le moment
	  }
	   
	  public boolean update(Eleves obj) {
	    return false; //pour le moment
	  }
	   
	  public Eleves find(int id) {
	    Eleves eleve = new Eleves();      
	      
	    try {
	      ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleves WHERE login = " + id);
		if(result.first())
	          eleve = new Eleves(
	            result.getString("nom"),
	            result.getString("prenom"),
	            result.getString("mdp"),
	            result.getString("dateNaiss"),
	            result.getString("adresse"),
	            result.getString("mail")
	            );         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return eleve;
	  }
}
