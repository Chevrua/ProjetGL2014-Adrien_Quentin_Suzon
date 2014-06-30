package org.ema.projet.dao;

import java.sql.Connection;

import org.ema.projet.metier.Professeur;

public abstract class ProfesseurDAO extends DAO<Professeur> {

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
