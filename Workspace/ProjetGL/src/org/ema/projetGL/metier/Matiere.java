package org.ema.projectGL.metier;
public class Matiere {
	protected String nomMatiere;

//Chaque action doit avoir un impact dans la BDD

public Matiere(String nomMatiere){
	this.nomMatiere = nomMatiere;
}


public String getNomMatiere(){return this.nomMatiere;
}


public void setNomMatiere(String nomMatiere){this.nomMatiere = nomMatiere;
}

}
