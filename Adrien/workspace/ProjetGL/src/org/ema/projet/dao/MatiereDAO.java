package org.ema.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ema.projet.metier.Matiere;

public abstract class MatiereDAO extends DAO<Matiere> {

	public  MatiereDAO(Connection conn){
		// TODO Auto-generated constructor stub
		super(conn);
	}
	 public boolean create(Matiere obj) {
		    return false;
		  }
		  public boolean delete(Matiere obj) {
		    return false;
		  }
		  public boolean update(Matiere obj) {
		    return false;
		  }
		  public Matiere find(int id) {
		    Matiere matiere = new Matiere();  
		    try {
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE, 
		        ResultSet.CONCUR_READ_ONLY
		      ).executeQuery("SELECT * FROM matiere WHERE id_mat = " + id);
		        if(result.first())
		          matiere = new Matiere();         
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return matiere;
		  }
}
