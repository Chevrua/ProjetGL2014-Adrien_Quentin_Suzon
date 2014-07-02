package org.ema.projet.metier;


public class Eleves extends Personne{
	private Parent mere;
	private Parent pere;
	private Classe idClasse;
	
//Chaque action doit avoir un impact dans la BDD

public Eleves(){
	super();
// création de la personne dans la BDD
}

public Eleves (String nom,String prenom, String mdp, String dateNaiss, String adresse, String mail){
	super(nom,prenom,mdp,dateNaiss,adresse,mail);
// création de la personne dans la BDD
}
	
public Parent getMere(){return this.mere;
}
public Parent getPere(){return this.pere;
}

public void setMere(Parent mere){this.mere = mere;
}
public void setPere(Parent pere){this.pere = pere;
}

public Classe getIdClasse() {
	return idClasse;
}

public void setIdClasse(Classe idClasse) {
	this.idClasse = idClasse;
}	
}
