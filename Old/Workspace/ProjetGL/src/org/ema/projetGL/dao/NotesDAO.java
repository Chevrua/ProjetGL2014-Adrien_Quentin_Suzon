package org.ema.projetGL.dao;

import java.sql.Connection;
import org.ema.projetGL.metier.Notes;

public abstract class NotesDAO extends DAO<Notes>{

	public NotesDAO(Connection conn) {
		// TODO Auto-generated constructor stub
		super(conn);
	}
	
	  public boolean create(Notes obj) {
	    return false;
	  }
	  public boolean delete(Notes obj) {
	    return false;
	  }	   
	  public boolean update(Notes obj) {
	    return false;
	  }
}
