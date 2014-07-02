package org.ema.projetGL.metier;
import java.util.Vector;


public class Professeur extends Personne{
	protected Vector<Classe> id_classe;

//Chaque action doit avoir un impact dans la BDD

public Professeur(){
	super();
// création de la personne dans la BDD
}

public Professeur (String nom,String prenom, String mdp, String dateNaiss, String adresse, String mail){
	super(nom,prenom,mdp,dateNaiss,adresse,mail);
// création de la personne dans la BDD
}


public void addClasse(Classe id_Classe ){
	this.id_classe.add(id_Classe);

}

public void supprClasse(Classe id_classe){
	this.id_classe.remove(id_classe);
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
