package org.ema.projet.bdd;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.ema.projet.metier.gestionException;

import com.sun.istack.internal.logging.Logger;


public class GestionIntProf {
	//Nombre Magic
	public static final int NB_COLONNE_TAB_NOTES = 4;
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

	public int getIdClasse(String className){
		int idClasse=0;
		Statement instruction;

		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet resultID;
			resultID = instruction.executeQuery( "SELECT id_classe FROM classe where nom = '"+className+"'");
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


	//------------------------Fonction pour récupérer le tableau des elèves du prof----------------------------------------


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

					for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
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

	public Object[][] getTabNotes(int idClasse, int sLigneNote){

		Object[][] don = new Object[sLigneNote][NB_COLONNE_TAB_NOTES];
		Statement instruction;
		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet resultat1 = instruction.executeQuery("SELECT eleves.nom,eleves.prenom,nommatiere,note FROM matiere,notes,classe,eleves where classe.id_classe = '"+idClasse+"' and eleves.id_classe = classe.id_classe and matiere.id_mat = notes.id_matiere and notes.id_eleve = eleves.login");
			try{
				ResultSetMetaData resultMeta = resultat1.getMetaData();
				int j=0;			
				while(resultat1.next()){ 		
					for(int i = 1; i <=resultMeta.getColumnCount(); i++) {
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


	//------------------------Fonction qui récupère le nom de la classe ----------------------------------------
	public  String getClassName(String login) {
		String res= "";
		Statement instruction;
		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet resultat = instruction.executeQuery("SELECT nom FROM classe WHERE id_profprcipal = '"+login+"'");
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

	// ----------------------- Fonction qui retourne le nombre de note des elèves d'un professeur-----------

	public int getNbNotes(int idClasse){
		int sLigne = 0;
		Statement instruction;
		try {
			instruction = GestionConnection.getConnection().createStatement();
			ResultSet nbLigne = instruction.executeQuery("SELECT COUNT(*) FROM matiere,notes,classe,eleves where classe.id_classe = '"+idClasse+"' and eleves.id_classe = classe.id_classe and matiere.id_mat = notes.id_matiere and notes.id_eleve = eleves.login");
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
