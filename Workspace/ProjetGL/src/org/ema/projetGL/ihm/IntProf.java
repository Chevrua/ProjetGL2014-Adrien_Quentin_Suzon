package org.ema.projectGL.ihm;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntProf extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton bouton = new JButton("Salut !");
	  private JButton bouton2 = new JButton("Bye bye !");
	  private JPanel container = new JPanel();
	  private JLabel label = new JLabel();
	  private JLabel label2 = new JLabel();
	  private JPanel Pbouton = new JPanel();
	  private JPanel Ptext = new JPanel();

	  public IntProf(String login, String pass)
	  {
	    this.setTitle("Interface professeur ");
	    this.setSize(300, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());	   
	    Pbouton.add(bouton);
	    Pbouton.add(bouton2);
	    container.add(Pbouton, BorderLayout.SOUTH);
	    
	    label.setText("votre nom est : " + login);
	    label2.setText(" et le MDP :" + pass);
	    Ptext.add(label);
	    Ptext.add(label2);	    
	
	    container.add(Ptext);  
	 
	    this.setContentPane(container);
	    this.setVisible(true);
	  }	
	  

	  
	  
	}