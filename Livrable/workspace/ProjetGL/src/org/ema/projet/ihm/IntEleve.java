
package org.ema.projet.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.ema.projet.bdd.GestionIntEleve;


@SuppressWarnings("serial")
public class IntEleve extends JFrame  {

    private JButton bouton = new JButton("Quitter");
    private JPanel container = new JPanel();
    private JLabel lblBonjourMr = new JLabel();
    private JLabel lblClassName = new JLabel();
    private JLabel lblProfPrinc = new JLabel();
    private JLabel lbltabEleve = new JLabel();
    private JPanel pBouton = new JPanel();

    private final JPanel panelPrinc = new JPanel();	
    private final JTabbedPane onglets = new JTabbedPane(JTabbedPane.TOP);
    private static boolean isOpen = false;

    //Nombres Magics 
    public static final int LARG_FEN = 1030;
    public static final int HAUT_FEN = 580;
    public static final int CONT_COLOR = 169;
    public static final int LARG_TAB = 940;
    public static final int HAUT_TAB_NOTES = 420;
    public static final int HAUT_TAB_CLASS = 320;
    public static final int POS_TAB = 115;
    public static final int WHITE_SPACE = 10;
    public static final int LONG_TEXT = 1000;
    public static final int POS_HAUT_1 = 10;
    public static final int POS_HAUT_2 = 40;
    public static final int POS_HAUT_3 = 60;
    public static final int POS_HAUT_4 = 90;
    public static final int POLICE_SIZE = 20;
    public static final int LARG_ONGLET = 980;
    public static final int HAUT_ONGLET = 480;
    public static final int SCOLONNE = 5;
    public static final int ZERO = 0;
    public static final int NB_LIGNE_TAB = 12;
    public static final int NB_COLONNE_TAB = 2;
    public static final int EMPTYBORDER = 5;




    public IntEleve(String login, String pass){
        setIconImage(Toolkit.getDefaultToolkit().getImage(FenetreAccueil.class.getResource("/org/ema/projet/img/logoMines.png")));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                IntEleve.setOpen(false);
            }
        });
        setOpen(true);
        this.setTitle("Interface élève");
        this.setSize(LARG_FEN, HAUT_FEN);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        GestionIntEleve myBdd = new GestionIntEleve();
        int idClasse = myBdd.getIdClasse(login, pass);
        int sLigne = myBdd.getNbEleve(idClasse);	

        int sColonne = SCOLONNE;
        Object[][] donnees = new Object[sLigne][sColonne];

        String[] entetes = {"Nom"," Prenom", "Date de Naissance", "Adresse","Parent"};	

        donnees = myBdd.getTabEleve(idClasse,sLigne,sColonne);	
        JTable tabClass = new JTable(donnees, entetes);


        String[] ent = {"Matière","Note"};
        int sligneNote = myBdd.getNbNotes(login);
        Object[][] donneeNote = new Object[sligneNote][NB_COLONNE_TAB];
        donneeNote = myBdd.getTabNotes(login,sligneNote);
        JTable tabNote = new JTable(donneeNote, ent);


        String profPrinc = myBdd.getProfPrinc(idClasse);
        String className = myBdd.getClassName(idClasse);	

        container = new JPanel();
        container.setBorder(new EmptyBorder(EMPTYBORDER, EMPTYBORDER, EMPTYBORDER, EMPTYBORDER));
        container.setBackground(new Color(CONT_COLOR, CONT_COLOR, CONT_COLOR));
        container.setLayout(new BorderLayout(ZERO, ZERO));
        setContentPane(container);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(panelPrinc, BorderLayout.CENTER);

        bouton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent arg0) {
                // permet de quitter l'appli en cliquant sur le bouton
                System.exit(ZERO);
            }
        });
        pBouton.add(bouton);
        container.add(pBouton, BorderLayout.SOUTH);

        lblBonjourMr.setText("Bienvenue dans votre carnet electronique, vous etes connecté en tant que : " + login);
        lblBonjourMr.setBounds(WHITE_SPACE, POS_HAUT_1, LONG_TEXT, POLICE_SIZE);
        lblClassName.setText("Vous etes dans la classe : "+ className);
        lblClassName.setBounds(WHITE_SPACE, POS_HAUT_2, LONG_TEXT, POLICE_SIZE);
        lblProfPrinc.setText("Votre professeur principal est  : "+ profPrinc);
        lblProfPrinc.setBounds(WHITE_SPACE, POS_HAUT_3, LONG_TEXT, POLICE_SIZE);
        lbltabEleve.setText("Voici la liste des élèves de votre classe : ");
        lbltabEleve.setBounds(WHITE_SPACE, POS_HAUT_4, LONG_TEXT, POLICE_SIZE);

        panelPrinc.setLayout(null);
        onglets.setBounds(ZERO, ZERO, LARG_ONGLET, HAUT_ONGLET);

        panelPrinc.add(onglets);


        onglets.setBounds(ZERO, ZERO, LARG_ONGLET, HAUT_ONGLET);
        onglets.setBackground(new Color(CONT_COLOR, CONT_COLOR, CONT_COLOR));
        panelPrinc.add(onglets);
        JPanel accueil = new JPanel();
        onglets.addTab("Accueil", accueil);
        accueil.setLayout(null);
        JPanel notes = new JPanel();
        onglets.addTab("Notes", notes);
        notes.setLayout(null);


        JScrollPane tabNotesScrollPane = new JScrollPane(tabNote);
        tabNotesScrollPane.setBounds(WHITE_SPACE, WHITE_SPACE, LARG_TAB, HAUT_TAB_NOTES);
        notes.add(tabNotesScrollPane);

        JScrollPane tabAccueilScrollPane = new JScrollPane(tabClass);
        tabAccueilScrollPane.setBounds(WHITE_SPACE, POS_TAB, LARG_TAB, HAUT_TAB_CLASS);



        accueil.add(lblBonjourMr, BorderLayout.NORTH);
        accueil.add(lblClassName, BorderLayout.NORTH);
        accueil.add(lblProfPrinc, BorderLayout.NORTH);
        accueil.add(lbltabEleve, BorderLayout.NORTH);
        accueil.add(tabAccueilScrollPane, BorderLayout.CENTER);	
    }


    public static boolean isOpen() {
        return isOpen;
    }


    public static void setOpen(boolean isOpen) {
        IntEleve.isOpen = isOpen;
    }
}
