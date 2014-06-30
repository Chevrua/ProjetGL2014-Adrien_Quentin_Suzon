package org.ema.projet.dao;

import java.sql.Connection;

import org.ema.projet.metier.Eleves;
import org.ema.projet.metier.Personne;
import org.ema.projet.bdd.GestionConnection;

public class TestLienBDD {

	public static void main(String[] args) {
	
		GestionConnection gestionBdd = new GestionConnection();
		Connection conn = GestionConnection.getConnection();

		ElevesDAO eleveDAO = new ElevesDAO(conn);
        for(int i = 1; i < 5; i++){
                Eleves eleve = eleveDAO.find(i);
                System.out.println("Elève - " + eleve.getNom() + " " + eleve.getPrenom());
        }
        
        System.out.println("\n******************************************\n");

	}

}
