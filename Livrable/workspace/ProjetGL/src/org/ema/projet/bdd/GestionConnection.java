package org.ema.projet.bdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.ema.projet.ihm.FenetreAccueil;
import org.ema.projet.metier.gestionException;

import com.sun.istack.internal.logging.Logger;




public class GestionConnection {
    private static Connection conn;
    // Connection
    @SuppressWarnings("static-access")
    public GestionConnection() throws Exception {

        try {
            Class.forName("org.postgresql.Driver");	      	         
            String url = "jdbc:postgresql://localhost:5432/BDD";
            String user = "postgres";
            String passwd = "admin";

            this.conn = DriverManager.getConnection(url, user, passwd);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
        }  
    }

    public static void main(String[] args){
        FenetreAccueil test = new FenetreAccueil();
    }   


    public static Connection getConnection(){
        return conn;
    }


    //-------------------Méthode qui teste si un nom est bien dans la table eleve--------------------------------------

    public String estEleve(String login, String pass) throws ClassNotFoundException, SQLException{			
        String res;			
        @SuppressWarnings("static-access")
        Statement state0 = this.conn.createStatement();
        @SuppressWarnings("static-access")
        Statement state1 = this.conn.createStatement();
        ResultSet result0 = state0.executeQuery("SELECT COUNT(*) FROM eleves where login = '"+login+"'");
        ResultSet result1 = state1.executeQuery("SELECT mdp FROM eleves where login = '"+login+"'"); 
        try{

            result0.next();
            result1.next();

            if ((result0.getInt(1) > 0 ) && (result1.getObject("mdp").toString().equals(pass))){
                res= login;
            }
            else{
                res= " Bizarre je ne connais pas cet eleve ! ";
            }		
        }   

        finally{
            state0.close();
            state1.close();
            result0.close();
            result1.close();
        }
        return res;
    }

    //-------------------Méthode qui teste si un nom est bien dans la table prof--------------------------------------

    public String estProf(String login, String pass) throws ClassNotFoundException, SQLException{			
        String res;			
        @SuppressWarnings("static-access")
        Statement state0 = this.conn.createStatement();
        @SuppressWarnings("static-access")
        Statement state1 = this.conn.createStatement();
        ResultSet result0 = state0.executeQuery("SELECT COUNT(*) FROM professeur where login = '"+login+"'");
        ResultSet result1 = state1.executeQuery("SELECT mdp FROM professeur where login = '"+login+"'"); 
        try{
            result0.next();
            result1.next();
            if ((result0.getInt(1) > 0 ) && (result1.getObject("mdp").toString().equals(pass))) {
                res= login;
            }
            else{
                res= " Bizarre je ne connais pas ce professeur ! ";		    	  
            }		    
        }
        finally{
            state0.close();
            state1.close();
            result0.close();
            result1.close();
        }
        return res;
    }
}




