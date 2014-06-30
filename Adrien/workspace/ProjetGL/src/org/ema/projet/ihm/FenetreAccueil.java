package org.ema.projet.ihm;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import org.ema.projet.bdd.GestionConnection;
import org.ema.projet.metier.gestionException;

import com.sun.istack.internal.logging.Logger;

@SuppressWarnings("serial")
public class FenetreAccueil extends JFrame {


	private JPanel container = new JPanel();
	private JTextField textField;
	private JPasswordField textField1;

	//Nombres Magics 
	public static final int LARG_FEN = 750;
	public static final int HAUT_FEN = 375;
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
	public static final int SCOLONNE = 8;
	public static final int ZERO = 0;
	public static final int NB_LIGNE_TAB = 12;
	public static final int NB_COLONNE_TAB = 32;
	public static final int EMPTYBORDER = 5;
	public static final int COLOR = 128;
	public static final int NB123 = 123;
	public static final int NB201 = 201;
	public static final int NB61 = 61;
	public static final int NB62 = 62;
	public static final int NB56 = 56;
	public static final int NB70 = 70;
	public static final int NB18 = 18;
	public static final int NB29 = 29;
	public static final int NB92 = 92;
	public static final int NB34 = 34;
	public static final int NB24 = 24;
	public static final int NB181 = 181;
	public static final int NB30 = 30;
	public static final int NB45= 45;
	public static final int NB368 = 368;
	public static final int NB117= 117;



	public FenetreAccueil( ) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FenetreAccueil.class.getResource("/org/ema/projet/img/logoMines.png")));
		this.setTitle("Carnet de notes électronique");
		this.setSize(LARG_FEN, HAUT_FEN);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(new Color(CONT_COLOR, CONT_COLOR, CONT_COLOR));


		this.setContentPane(container);

		textField = new JTextField();
		textField.setBackground(UIManager.getColor("Button.light"));
		textField.setColumns(WHITE_SPACE);

		textField1 = new JPasswordField();
		textField1.setBackground(UIManager.getColor("Button.light"));
		textField1.setColumns(WHITE_SPACE);

		JLabel lblLogin = new JLabel("Login :");	    
		JLabel lblMotDePasse = new JLabel("Mot de passe :");	    
		JLabel  lblBonjoursLesAmis = new JLabel("Bonjour !");	    
		JLabel  lblNewLabel = new JLabel("Connectez-vous pour acc\u00E9der \u00E0 votre carnet \u00E9lectronique.");

		JLabel lblNewLabel1 = new JLabel("");
		URL url = FenetreAccueil.class.getResource("/org/ema/projet/img/logoMines.png");
		lblNewLabel1.setIcon(new ImageIcon(url));

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String sLogin = textField.getText();
					@SuppressWarnings("deprecation")
					String sPass = textField1.getText();

					GestionConnection gestionConnection = new GestionConnection();

					if (sLogin.equals(gestionConnection.estEleve(sLogin, sPass))) {
						if (IntEleve.isOpen() == false){
							IntEleve fenEleve = new IntEleve(sLogin, sPass);
							fenEleve.setVisible(true);
						}
					}
					else if (sLogin.equals(gestionConnection.estProf(sLogin, sPass))){
						IntProf fenProf = new IntProf(sLogin,sPass);
						fenProf.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "Erreur de Login / MdP", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					Logger.getLogger(gestionException.class.getName(), null).log(Level.SEVERE,null,e);
				}	
			}
		});


		btnNewButton.setForeground(new Color(ZERO, ZERO, ZERO));
		btnNewButton.setBackground(new Color(ZERO, COLOR, ZERO));
		btnNewButton.setIcon(null);
		GroupLayout glContainer = new GroupLayout(container);
		glContainer.setHorizontalGroup(
				glContainer.createParallelGroup(Alignment.TRAILING)
				.addGroup(glContainer.createSequentialGroup()
						.addGroup(glContainer.createParallelGroup(Alignment.LEADING)
								.addGroup(glContainer.createSequentialGroup()
										.addContainerGap(NB123, Short.MAX_VALUE)
										.addGroup(glContainer.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblLogin)
												.addComponent(lblMotDePasse))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(glContainer.createParallelGroup(Alignment.LEADING)
														.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGap(NB201))
														.addGroup(glContainer.createSequentialGroup()
																.addGap(NB61)
																.addGroup(glContainer.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, NB368, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblBonjoursLesAmis))
																		.addGap(NB62)))
																		.addGroup(glContainer.createParallelGroup(Alignment.LEADING)
																				.addGroup(glContainer.createSequentialGroup()
																						.addGap(NB56)
																						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, NB117, GroupLayout.PREFERRED_SIZE)
																						.addGap(NB70))
																						.addGroup(glContainer.createSequentialGroup()
																								.addGap(NB18)
																								.addComponent(lblNewLabel1, ZERO, ZERO, Short.MAX_VALUE)
																								.addContainerGap())))
				);





		glContainer.setVerticalGroup(
				glContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(glContainer.createSequentialGroup()
						.addGap(NB29)
						.addGroup(glContainer.createParallelGroup(Alignment.LEADING)
								.addGroup(glContainer.createSequentialGroup()
										.addComponent(lblBonjoursLesAmis)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, NB34, GroupLayout.PREFERRED_SIZE)
										.addGap(NB92)
										.addGroup(glContainer.createParallelGroup(Alignment.TRAILING)
												.addGroup(glContainer.createSequentialGroup()
														.addGroup(glContainer.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblLogin)
																.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGap(NB24)
																.addComponent(lblMotDePasse))
																.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
																.addComponent(lblNewLabel1, GroupLayout.PREFERRED_SIZE, NB181, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.RELATED, NB30, Short.MAX_VALUE)
																.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, NB45, GroupLayout.PREFERRED_SIZE)
																.addGap(NB29))
				);
		container.setLayout(glContainer);
		this.setVisible(true); 
	}	
}