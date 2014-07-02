package org.ema.projet.bdd;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.ema.projet.metier.gestionException;

import com.sun.istack.internal.logging.Logger;

public class GestionIntEleve {

	//-------------------Fonction qui récupère le nombre d'eleves dans la classe--------------------------------------
	public int getNbEleve(int idClasse){
		int sLigne = 0;
		Statement instruction;
		try {

			instruction = GestionConnection.getConnection().createStatement();
			ResultSet nbLigne = instruction.executeQuery("SELECT COUNT(*) FROM eleves where id_classe = '"+idClasse+"'");
			try{
				nbLigne.next();
				sLigne = Integer.parseInt(nbLigne.getObject(1).toString());
			}
			finally{
				instruction.close();
				nbLigne.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
		}                                         
		return sLigne;		
	}

	//-------------------Fonction qui récupère l'Id_classe--------------------------------------

	public int getIdClasse(String login, String pass){
		int idClasse=0;
		Statement instruction;

		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet resultID;
			resultID = instruction.executeQuery( "SELECT id_classe FROM eleves where login = '"+login+"'");
			try{
				ResultSetMetaData resultMeta = resultID.getMetaData();
				//On parcour les lignes 
				while(resultID.next()){    

					for(int i = 1; i <= resultMeta.getColumnCount(); i++){
						idClasse= Integer.parseInt(resultID.getObject(1).toString());
					}
				}		    		
			}
			finally{
				instruction.close();
				resultID.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
		}
		return idClasse;
	}


	//------------------------Fonction pour récupérer le tableau des élèves de la classe----------------------------------------


	public Object[][] getTabEleve(int idClasse,int sLigne,int sColonne){
		Object[][] donnees = new Object[sLigne][sColonne];
		Statement instruction;

		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet resultat = instruction.executeQuery("SELECT nom,prenom,datenaiss,adresse,id_parent FROM eleves where id_classe ='"+idClasse+"'");
			try{
				ResultSetMetaData resultMeta = resultat.getMetaData();

				int j=0;
				while(resultat.next()){ 
					for(int i = 1; i <= resultMeta.getColumnCount(); i++){
							donnees[j][i-1]=resultat.getObject(i);  
					}	        	
					j++;	    		
				}			
			}
			finally{
				instruction.close();
				resultat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
		}	
		return donnees;
	}

	//------------------------Fonction pour récupérer le tableau note dans l'onglet Notes----------------------------------------

	public Object[][] getTabNotes(String login, int sLigneNote){
		Object[][] don = new Object[sLigneNote][2];
		Statement instruction;
		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet resultat1 = instruction.executeQuery("SELECT nommatiere,note FROM matiere,notes where matiere.id_mat = notes.id_matiere and id_eleve ='"+login+"'");
			try{
				ResultSetMetaData resultMeta = resultat1.getMetaData();
				int j=0;			
				while(resultat1.next()){ 					
					for(int i = 1; i <= resultMeta.getColumnCount(); i++){
						don[j][i-1]=resultat1.getObject(i);          	
					}
					j++;
				}			
			}
			finally{
				instruction.close();
				resultat1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
		}	
		return don;		
	}

	//------------------------Fonction qui récupère le nom du prof principal----------------------------------------


	public String getProfPrinc(int idClasse){
		String res = "";
		Statement instruction;
		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet resultat1 = instruction.executeQuery("SELECT id_profprcipal FROM classe WHERE id_classe ='"+idClasse+"'");
			try{
				
				resultat1.next();
				res = resultat1.getString(1);
			}
			finally{
				instruction.close();
				resultat1.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
		}


		return res;
	}

	//------------------------Fonction qui récupère le nom de la classe ----------------------------------------
	public  String getClassName(int idClasse) {
		String res= "";
		Statement instruction;
		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet resultat = instruction.executeQuery("SELECT nom FROM classe WHERE id_classe = '"+idClasse+"'");
			try{
				resultat.next();
				res =  resultat.getString(1);			
			}
			finally{
				instruction.close();
				resultat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
		}


		return res;
	}	

	// ----------------------- Fonction qui retourne le nombre de note d'un élève ----------------------------

	public int getNbNotes(String login){
		int sLigne = 0;
		Statement instruction;
		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet nbLigne = instruction.executeQuery("SELECT COUNT(*) FROM notes where id_eleve = '"+login+"'");
			try{
				nbLigne.next();
				sLigne = Integer.parseInt(nbLigne.getObject(1).toString());
			}
			finally{
				instruction.close();
				nbLigne.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
		}        


		return sLigne;		
	}
}
