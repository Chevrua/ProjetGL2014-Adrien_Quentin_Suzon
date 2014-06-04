package org.ema.projetGL.metier;
public class ProfPrincipal extends Professeur{

	protected Classe classePrinc;

//Chaque action doit avoir un impact dans la BDD
public ProfPrincipal(){
	super();
}

public ProfPrincipal(String nom,String prenom, String mdp, String dateNaiss, String adresse, String mail){
	super(nom,prenom,mdp,dateNaiss,adresse,mail);
}


public Classe getClassePrinc(){
	return this.classePrinc;
}
public void setClassePrinc(Classe ClassePrinc){
	this.classePrinc = ClassePrinc;
}

}
