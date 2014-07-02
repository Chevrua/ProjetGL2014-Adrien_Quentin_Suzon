package org.ema.projetGL.dao;

import java.sql.Connection;
import org.ema.projetGL.metier.Parent;

public abstract class ParentsDAO extends PersonneDAO {

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
