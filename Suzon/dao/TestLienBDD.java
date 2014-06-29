package org.ema.projetGL.dao;

import java.sql.Connection;

import org.ema.projetGL.metier.Eleves;
import org.ema.projetGL.metier.Personne;
import org.ema.projetGL.bdd.GestionBdd;

public class TestLienBDD {

	public static void main(String[] args) {
	
		GestionBdd gestionBdd = new GestionBdd();
		Connection conn = GestionBdd.getConnection();

		ElevesDAO eleveDAO = new ElevesDAO(conn);
        for(int i = 1; i < 5; i++){
                Eleves eleve = eleveDAO.find(i);
                System.out.println("Elève - " + eleve.getNom() + " " + eleve.getPrenom());
        }
        
        System.out.println("\n******************************************\n");

	}

}
