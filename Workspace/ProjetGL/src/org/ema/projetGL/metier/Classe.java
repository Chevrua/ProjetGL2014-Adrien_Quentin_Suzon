package org.ema.projectGL.metier;

public class Classe {
	protected String nom;
	protected Professeur profprcipal;

//Chaque action doit avoir un impact dans la BDD

public Classe(String nom, Professeur profprcipal){
	this.nom = nom;
	this.profprcipal = profprcipal;
}

public void addEleve (Eleves c1){
	c1.id_classe = this;
}

public void SuppEleve(Eleves e1){
//A creer
}
	
	
	
public String getNom(){return this.nom;
}
public Professeur getProfPrcipal(){return this.profprcipal;
}
	
public void setNom(String nom){this.nom = nom;
}
public void setProfPrcipalNom(Professeur profprcipal){this.profprcipal = profprcipal;
}
}
