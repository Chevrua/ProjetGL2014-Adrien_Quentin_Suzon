package org.ema.projetGL.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.ema.projetGL.bdd.GestionBdd;
import org.ema.projetGL.ihm.OngTabNotes;

public class IntEleve extends JFrame implements OngTabNotes {

	/**
	 * 
	 */
	private JButton bouton = new JButton("Salut !");
	private JButton bouton2 = new JButton("Bye bye !");
	private JPanel container = new JPanel();
	private JLabel lblBonjoursMr = new JLabel();
	private JLabel lblClassName = new JLabel();
	private JPanel Pbouton = new JPanel();
	private JPanel Ptext = new JPanel();
	private final JPanel PanelPrinc = new JPanel();	
	private final JTabbedPane Onglets = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Create the frame.
	 */


	public IntEleve(String login, String pass) throws Exception{
		this.setTitle("Interface éleve ");
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);



		Class.forName("org.postgresql.Driver" );                                               //Initialisation du pilote de base de données
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDD", "postgres", "admin" ); //Connexion à ta base de données
		Statement instruction = con.createStatement();                                         //Création du statement

		// Taille du tableau défini à l'avance dynamiquement pour les lignes mais fixe pour les colonnes
		// Attention à l'ordre des ResultSet on ne peut en ou
		ResultSet nbLigne = instruction.executeQuery("SELECT COUNT(*) FROM eleves");

		// Semble obligatoire
		nbLigne.next();


		int Sligne = (int) (long) nbLigne.getObject(1);
		
		
		int Scolonne = 8;
		Object[][] donnees = new Object[Sligne][Scolonne];

		//  Défini les entetes
		String[] entetes = {"login", "mdp", "nom"," prenom", "datenaiss", "adresse","id_parent","id_classe"};
		//wait();
		//On défini la requete
		
		ResultSet ResultID = instruction.executeQuery( "SELECT id_classe FROM eleves where login = '"+login+"'");
		ResultID.next();

		

		int id_classe= Integer.parseInt(ResultID.getObject(1).toString());
		
	
		// where id_classe ='"+id_classe+"'
		ResultSet resultat = instruction.executeQuery("SELECT * FROM eleves");
		//ResultID.deleteRow();
		resultat.next();
		

		for(int j=0;j<12;j++) //Change la ligne
		{   	

			for(int i=1;i<9;i++){ // Change la colonne

				donnees[j][i-1]=resultat.getObject(i);  

			}
			resultat.next();
		}
		
		JTable tableau = new JTable(donnees, entetes);
		

		//String[] ent = {"1","2"};

		//Object[][] don = new Object[2][2];
	//	JTable tableau2 = new JTable(don, ent);

		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(new Color(169, 169, 169));
		container.setLayout(new BorderLayout(0, 0));
		setContentPane(container);

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(PanelPrinc, BorderLayout.CENTER);

		Pbouton.add(bouton);
		Pbouton.add(bouton2);
		container.add(Pbouton, BorderLayout.SOUTH);

		lblBonjoursMr.setText("Bonjours Mr : "+login);
		PanelPrinc.setLayout(null);
		Onglets.setBounds(0, 0, 1000, 500);

		PanelPrinc.add(Onglets);


		Onglets.setBounds(0, 0,1000, 500);
		Onglets.setBackground(new Color(169, 169, 169));
		PanelPrinc.add(Onglets);
		JPanel Accueil = new JPanel();
		Onglets.addTab("Accueil", Accueil);
		Accueil.setLayout(null);
		JPanel Notes = new JPanel();
		Onglets.addTab("Notes", Notes);
		Notes.setLayout(null);

	//	JTable tableau2 = getTabNotes();

		JScrollPane tab2scrollPane = new JScrollPane(tableau2);
		tab2scrollPane.setBounds(10, 10, 940, 365);
		Notes.add(tab2scrollPane);

		JScrollPane tabscrollPane = new JScrollPane(tableau);
		tabscrollPane.setBounds(10, 10, 940, 365);
		Accueil.add(tabscrollPane);
		//resultat.deleteRow();
	}
/*		try {
			GestionBdd GestBDD = new GestionBdd();
			//	lblClassName.setText("Votre classe : "+GestBDD.GetClassName(login));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Ptext.add(lblBonjoursMr);
		Ptext.add(lblClassName);

		container.add(Ptext,BorderLayout.NORTH);


		this.setContentPane(container);
		this.setVisible(true);
	}*/



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntEleve frame = new IntEleve("Login", "MdP");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
