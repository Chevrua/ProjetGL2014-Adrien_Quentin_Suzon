package org.ema.projetGL.dao;

import java.sql.Connection;
import org.ema.projetGL.metier.Professeur;

public abstract class ProfesseurDAO extends PersonneDAO {

	public ProfesseurDAO(Connection conn) {
		// TODO Auto-generated constructor stub
		super(conn);
	}

	  public boolean create(Professeur obj) {
		    return false; //pour le moment
		  }
		  public boolean delete(Professeur obj) {
		    return false; //pour le moment
		  }
		   
		  public boolean update(Professeur obj) {
		    return false; //pour le moment
		  }
}
