package org.ema.projetGL.ihm;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;



public interface OngTabNotes {
	String[] ent = {"1","2"};

	Object[][] don = new Object[2][2];
	JTable tableau2 = new JTable(don, ent);
}
