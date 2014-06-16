package org.ema.projetGL.ihm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class IntProf extends JFrame {

	 
	  private JButton bouton = new JButton("Salut !");
	  private JButton bouton2 = new JButton("Bye bye !");
	  private JPanel container = new JPanel();
	  private JLabel lblVotreNomEst = new JLabel();
	  private JLabel lblMdP = new JLabel();
	  private JPanel Pbouton = new JPanel();
	  private JPanel Ptext = new JPanel();
	  private final JTabbedPane Onglets = new JTabbedPane(JTabbedPane.TOP);

	  public IntProf(String login, String pass) throws ClassNotFoundException, SQLException
	  {
	    this.setTitle("Interface professeur ");
	    this.setSize(1000, 500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    container.setBackground(new Color(169, 169, 169));
	    container.setLayout(new BorderLayout());	   
	    Pbouton.add(bouton);
	    Pbouton.add(bouton2);
	    container.add(Pbouton, BorderLayout.SOUTH);
	
	    container.add(Ptext);  
	    Ptext.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(0, 0, 980, 430);
	    Ptext.add(panel);
	    panel.setLayout(null);
	    
	    Onglets.setBounds(0, 0, 980, 430);
	    Onglets.setBackground(new Color(169, 169, 169));
		panel.add(Onglets);
		
		
		JPanel Accueil = new JPanel();
		Onglets.addTab("Accueil", Accueil);
		Accueil.setLayout(null);
		lblVotreNomEst.setBounds(10, 25, 200, 14);
		Accueil.add(lblVotreNomEst);
		lblVotreNomEst.setText("Votre nom est : "+login);
		lblMdP.setBounds(10, 55, 200, 14);
		Accueil.add(lblMdP);
		lblMdP.setText(" MDP : "+pass);
		
		JLabel lblBonjour = new JLabel("Bonjour et bienvenue");
		lblBonjour.setBounds(10, 10, 200, 14);
		Accueil.add(lblBonjour);
		
		JLabel lblVotrePrnomEst = new JLabel();
		lblVotrePrnomEst.setBounds(10, 40, 200, 14);
		lblVotrePrnomEst.setText("Votre pr\u00E9nom est : <dynamic>");
		Accueil.add(lblVotrePrnomEst);
		JPanel classe = new JPanel();
		Onglets.addTab("Classe", classe);
		classe.setLayout(null);
		

		Class.forName("org.postgresql.Driver" );                                               //Initialisation du pilote de base de données
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDD", "postgres", "admin" ); //Connexion à ta base de données
		Statement instruction = con.createStatement();                                         //Création du statement

		// Taille du tableau défini à l'avance dynamiquement pour les lignes mais fixe pour les colonnes
		// Attention à l'ordre des ResultSet on ne peut en ou
	//	ResultSet nomCla = instruction.executeQuery("Select nom from classe where id_profprcipal = '"+login+"'");
		ResultSet idCla = instruction.executeQuery("Select id_classe from classe where id_profprcipal = '"+login+"'");
		idCla.next();
		int idClasse = (int) (long) idCla.getObject(1);
		
		
		ResultSet nbeleves = instruction.executeQuery("SELECT COUNT(*) FROM eleves where id_classe = '"+idClasse+"'");
		// Semble obligatoire
		nbeleves.next();
		

		int Sligne =(int) (long) nbeleves.getObject(1);
		int Scolonne = 8;
		Object[][] donnees = new Object[Sligne][Scolonne];

		//  Défini les entetes
		String[] entetes = {"login", "mdp", "nom"," prenom", "datenaiss", "adresse","id_parent","id_classe"};

		//On défini la requete

		ResultSet Cla = instruction.executeQuery("Select * from eleves where id_classe = '"+idClasse+"'");
		Cla.next();


		for(int j=0;j<12;j++) //Change la ligne
		{   	

			for(int i=1;i<9;i++){ // Change la colonne

				donnees[j][i-1]=Cla.getObject(i);  

			}
			Cla.next();
		}

		JTable tableau = new JTable(donnees, entetes);
		JScrollPane tabscrollPane = new JScrollPane(tableau);
		tabscrollPane.setBounds(10, 10, 940, 365);
		classe.add(tabscrollPane);
	 
	    this.setContentPane(container);
	    this.setVisible(true);
	  }	
	}