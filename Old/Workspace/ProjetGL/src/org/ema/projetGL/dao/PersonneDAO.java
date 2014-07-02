package org.ema.projetGL.dao;

import java.sql.Connection;

import org.ema.projetGL.metier.Personne;

public abstract class PersonneDAO extends DAO<Personne> {

	public PersonneDAO(Connection conn){
		// TODO Auto-generated constructor stub
		super(conn);
	}

}
