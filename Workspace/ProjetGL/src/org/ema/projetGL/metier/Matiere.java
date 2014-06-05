package org.ema.projetGL.metier;
public class Matiere {
	protected String nomMatiere;

//Chaque action doit avoir un impact dans la BDD

public Matiere(){
	this.nomMatiere = "Matière par défaut";
}
	
public Matiere(String nomMatiere){
	this.nomMatiere = nomMatiere;
}


public String getNomMatiere(){return this.nomMatiere;
}


public void setNomMatiere(String nomMatiere){this.nomMatiere = nomMatiere;
}

}
