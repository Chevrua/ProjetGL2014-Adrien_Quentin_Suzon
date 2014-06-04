package org.ema.projectGL.ihm;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.ema.projectGL.bdd.GestionBdd;

public class IntEleve extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton bouton = new JButton("Salut !");
	  private JButton bouton2 = new JButton("Bye bye !");
	  private JPanel container = new JPanel();
	  private JLabel lblBonjoursMr = new JLabel();
	  private JLabel lblClassName = new JLabel();
	  private JPanel Pbouton = new JPanel();
	  private JPanel Ptext = new JPanel();
	  

	  public IntEleve(String login, String pass){
	    this.setTitle("Interface éleve ");
	    this.setSize(300, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	   
	    Pbouton.add(bouton);
	    Pbouton.add(bouton2);
	    container.add(Pbouton, BorderLayout.SOUTH);
	     
	    lblBonjoursMr.setText("Bonjours Mr : "+login);
	    GestionBdd toto;
		try {
			toto = new GestionBdd();
		//	lblClassName.setText("Votre classe : "+toto.GetClassName(login));
		} catch (Exception e) {
			e.printStackTrace();
		}
	    Ptext.add(lblBonjoursMr);
	    Ptext.add(lblClassName);
	
	    container.add(Ptext);
	    
	 
	    this.setContentPane(container);
	    this.setVisible(true);
	  }	
	  

	  
	  
	}