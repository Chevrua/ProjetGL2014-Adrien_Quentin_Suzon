package org.ema.projet.dao;

import java.sql.Connection;

import org.ema.projet.metier.ProfPrincipal;

public abstract class ProfPrincipalDAO extends DAO<ProfPrincipal> {

	public ProfPrincipalDAO(Connection conn) {
	    super(conn);
	  }
	  public boolean create(ProfPrincipal obj) {
	    return false; //pour le moment
	  }
	  public boolean delete(ProfPrincipal obj) {
	    return false; //pour le moment
	  }
	   
	  public boolean update(ProfPrincipal obj) {
	    return false; //pour le moment
	  }

}
