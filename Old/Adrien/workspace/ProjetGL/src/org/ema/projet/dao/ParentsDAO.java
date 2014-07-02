package org.ema.projet.dao;

import java.sql.Connection;
import org.ema.projet.metier.Parent;

public abstract class ParentsDAO extends DAO<Parent> {

	public ParentsDAO(Connection conn) {
		// TODO Auto-generated constructor stub
		super(conn);
	}

	public boolean create(Parent obj) {return false;
	}
	public boolean delete(Parent obj) {return false;
	}	   
	public boolean update(Parent obj) {return false;
	}
	
	}
