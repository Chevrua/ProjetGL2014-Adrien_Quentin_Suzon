package org.ema.projectGL.bdd;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class TestBdd {
	
	public TestBdd() {
		//constructeur de la classe
	}

	public static void main(String[] args) {
		try {
			
		    GestionBdd gestionBdd = new GestionBdd();
			Connection conn = gestionBdd.getConnection();
		   
		//Création d'un objet Statement
	      Statement state = conn.createStatement();
	      //L'objet ResultSet contient le résultat de la requête SQL
	      ResultSet result = state.executeQuery("SELECT * FROM classe");
	      //On récupère les MetaData (permet de recupérer le nbr de colonnes)
	      ResultSetMetaData resultMeta = result.getMetaData();
	         
	      System.out.println("\n**********************************");
	      //On affiche le nom des colonnes
	      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
	        System.out.println("\n**********************************");
	        
	       //L'en tete du tableau est crée on va mtn remplir les colonnes  
	        
	      while(result.next()){  //On parcour les lignes       
	        for(int i = 1; i <= resultMeta.getColumnCount(); i++) //On parcour les colonnes
	          System.out.print("\t" + result.getObject(i).toString() + "\t |");//Affiche le contenu des colonnes de la premiere ligne
	            
	        System.out.println("\n---------------------------------");//fin de la 1ere ligne on retourne ds le while pour la 2eme

	      }

	      result.close();
	      state.close();
	      System.out.println("---------------------hey !-------------------------------");
	      Statement state2 = conn.createStatement();
	      ResultSet result2 = state2.executeQuery("SELECT cls_nom FROM classe Where cls_id = '4' ");
	      //ResultSetMetaData resultMeta3 = result2.getMetaData();
	      result2.next();
	      System.out.println("Classe :" + result2.getObject("cls_nom").toString());
	      
	      System.out.println("------------------------:p----------------------------");  
	      
	      //affiche seulement le non et le prenom de tous les eleves correspondant a la contrainte
	      Statement state3 = conn.createStatement();
	      ResultSet result3 = state3.executeQuery("SELECT * FROM eleve Where elv_cls_k = '4' ");
	      while(result3.next())
	      {
	    	  //for(int j = 1; j <= resultMeta3.getColumnCount(); j++)
	    		  //System.out.println("\t" + result3.getObject(j) +"\t" );
	    	  System.out.println("\t" + result3.getString("elv_nom") + "\t" + result3.getString("elv_prenom") );
	    	  //System.out.println("\t" + result3.getString("elv_nom") +"\t" );
	      }
	      
	      System.out.println("----------------------------------------------------");
	      
	      //on va afficher le contenu de chaque colonne et de chaque ligne suivant la contrainte
	      Statement state4 = conn.createStatement();
	      ResultSet result4 = state4.executeQuery("SELECT * FROM eleve Where elv_cls_k = '4' ");
	      ResultSetMetaData resultMeta4 = result4.getMetaData();
	      while(result4.next()){
	    	  for(int j = 1; j <= resultMeta4.getColumnCount(); j++)
	    		  System.out.print(result4.getObject(j).toString() +"\t" );
	    	  	  System.out.println("");  	     
	      }
	      
	      ResultSet result5 = state4.executeQuery("SELECT COUNT(*) FROM eleve Where elv_cls_k = '4' ");
	      
	      System.out.print("********************************************** \n" );
	      result5.next();
	      System.out.print(result5.getInt(1));
	      System.out.println("\n////////////////////////////////////////////////////");
     
	      gestionBdd.EstEleve("MARLEY");
	      gestionBdd.EstProf("BORA");
	      
	     } catch (Exception e) {
	      e.printStackTrace();
	   }      
	    System.out.println("\n--------------------------Oh Bordel ---------------------------------");
	  } 
	}

