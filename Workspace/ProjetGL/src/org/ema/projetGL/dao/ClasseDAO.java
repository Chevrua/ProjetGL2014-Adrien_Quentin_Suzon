package org.ema.projetGL.dao;

import java.sql.Connection;

import org.ema.projetGL.metier.Classe;

public abstract class ClasseDAO extends DAO<Classe>{

	public ClasseDAO(Connection conn) {
		// TODO Auto-generated constructor stub
		super(conn);
	}
	
	public boolean create(Classe obj) {
	    return false;
	  }
	  public boolean delete(Classe obj) {
	    return false;
	  }
	   
	  public boolean update(Classe obj) {
	    return false;
	  }
}
