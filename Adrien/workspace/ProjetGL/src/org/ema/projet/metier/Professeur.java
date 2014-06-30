package org.ema.projet.metier;
import java.util.Vector;


public class Professeur extends Personne{
	private Vector<Classe> idClasse;

//Chaque action doit avoir un impact dans la BDD

public Professeur(){
	super();
// création de la personne dans la BDD
}

public Professeur (String nom,String prenom, String mdp, String dateNaiss, String adresse, String mail){
	super(nom,prenom,mdp,dateNaiss,adresse,mail);
// création de la personne dans la BDD
}


public void addClasse(Classe idClasse ){
	this.idClasse.add(idClasse);

}

public void supprClasse(Classe idClasse){
	this.idClasse.remove(idClasse);
}

public void insereNote(int note){
// A creer
}
public void insereComm(String comm){
// A creer
}

public void deleteNote(){
// A creer
}
public void deleteComm(){
// A creer
}
}
