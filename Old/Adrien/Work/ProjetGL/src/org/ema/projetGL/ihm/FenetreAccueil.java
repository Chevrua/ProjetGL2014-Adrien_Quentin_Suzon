package org.ema.projetGL.ihm;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import org.ema.projetGL.bdd.GestionBdd;

public class FenetreAccueil extends JFrame {
	
	

	 // public static void main(String[] args) {
	    //new FenetreAccueil();
	//  }
	  private JPanel container = new JPanel();
	  private JTextField textField;
	  private JTextField textField_1;
	  private JLabel lblBonjoursLesAmis;
	  private JLabel lblNewLabel;
	  private JLabel lblNewLabel_1;

	  public FenetreAccueil( ) {
	  	setIconImage(Toolkit.getDefaultToolkit().getImage(FenetreAccueil.class.getResource("/org/ema/projetGL/img/batman.jpg")));
	    this.setTitle("Carnet de notes électronique");
	    this.setSize(750, 375);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    container.setBackground(new Color(169, 169, 169));
	    
	 
	    this.setContentPane(container);
	    
	    textField = new JTextField();
	    textField.setBackground(UIManager.getColor("Button.light"));
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setBackground(UIManager.getColor("Button.light"));
	    textField_1.setColumns(10);
	    
	    JLabel lblLogin = new JLabel("Login :");
	    
	    JLabel lblMotDePasse = new JLabel("Mot de passe :");
	    
	    lblBonjoursLesAmis = new JLabel("Bonjour !");
	    
	    lblNewLabel = new JLabel("Connectez-vous pour acc\u00E9der \u00E0 votre carnet \u00E9lectronique.");
	    
	    lblNewLabel_1 = new JLabel("");
	    URL url = FenetreAccueil.class.getResource("/org/ema/projetGL/img/logoMines.png");
	    lblNewLabel_1.setIcon(new ImageIcon(url));
	    
	    JButton btnNewButton = new JButton("Valider");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		try {
	    			
	    		String Slogin = textField.getText();
	    		String Spass = textField_1.getText();
	    		
	    		GestionBdd gestionBdd = new GestionBdd();
				//Connection conn = gestionBdd.getConnection();
				
	    		if (Slogin.equals(gestionBdd.EstEleve(Slogin))) {
	    		IntEleve F1 = new IntEleve(Slogin, Spass);
	    		F1.setVisible(true);
	    		}
	    		else if (Slogin.equals(gestionBdd.EstProf(Slogin))){
		    			IntProf F2 = new IntProf(Slogin,Spass);
		    			F2.setVisible(true);
		    		}
		    		else{
		    			JOptionPane.showMessageDialog(null, "Erreur de Login / MdP", "Erreur", JOptionPane.ERROR_MESSAGE);
		    		}
	    		 } catch (Exception e) {
	    		      e.printStackTrace();
	    		 }	
	    	}
	    });
	    btnNewButton.setForeground(new Color(0, 0, 0));
	    btnNewButton.setBackground(new Color(0, 128, 0));
	    btnNewButton.setIcon(null);
	    GroupLayout gl_container = new GroupLayout(container);
	    gl_container.setHorizontalGroup(
	    	gl_container.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(gl_container.createSequentialGroup()
	    			.addGroup(gl_container.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_container.createSequentialGroup()
	    					.addContainerGap(123, Short.MAX_VALUE)
	    					.addGroup(gl_container.createParallelGroup(Alignment.TRAILING)
	    						.addComponent(lblLogin)
	    						.addComponent(lblMotDePasse))
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addGroup(gl_container.createParallelGroup(Alignment.LEADING)
	    						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    					.addGap(201))
	    				.addGroup(gl_container.createSequentialGroup()
	    					.addGap(61)
	    					.addGroup(gl_container.createParallelGroup(Alignment.LEADING)
	    						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblBonjoursLesAmis))
	    					.addGap(62)))
	    			.addGroup(gl_container.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_container.createSequentialGroup()
	    					.addGap(56)
	    					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
	    					.addGap(70))
	    				.addGroup(gl_container.createSequentialGroup()
	    					.addGap(18)
	    					.addComponent(lblNewLabel_1, 0, 0, Short.MAX_VALUE)
	    					.addContainerGap())))
	    );
	    gl_container.setVerticalGroup(
	    	gl_container.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_container.createSequentialGroup()
	    			.addGap(29)
	    			.addGroup(gl_container.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_container.createSequentialGroup()
	    					.addComponent(lblBonjoursLesAmis)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	    					.addGap(92)
	    					.addGroup(gl_container.createParallelGroup(Alignment.TRAILING)
	    						.addGroup(gl_container.createSequentialGroup()
	    							.addGroup(gl_container.createParallelGroup(Alignment.BASELINE)
	    								.addComponent(lblLogin)
	    								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    							.addGap(24)
	    							.addComponent(lblMotDePasse))
	    						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
	    			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
	    			.addGap(29))
	    );
	    container.setLayout(gl_container);
	    this.setVisible(true); 
	  }	
	}