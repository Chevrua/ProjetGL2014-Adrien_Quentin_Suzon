package org.ema.projet.metier;
public class Matiere {
	private String nomMatiere;

//Chaque action doit avoir un impact dans la BDD

public Matiere(String nomMatiere){
	this.nomMatiere = nomMatiere;
}


public Matiere() {
	// TODO Auto-generated constructor stub
}


public String getNomMatiere(){return this.nomMatiere;
}


public void setNomMatiere(String nomMatiere){this.nomMatiere = nomMatiere;
}

}
