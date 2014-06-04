package org.ema.projectGL.metier;
public class Personne {
	protected String nom;
	protected String prenom;
	protected String mdp;
	protected String dateNaiss;
	protected String adresse;
	protected String mail;

//Chaque action doit avoir un impact dans la BDD

public Personne(){
	this.nom = "Default_Nom";
	this.prenom = "Default_Prenom";
	this.mdp = "00000000";
	this.adresse = "Default_Adresse";
	this.dateNaiss="01/01/1900";
	this.mail="Default.mail@mail.com";
// création de la personne dans la BDD
}

public Personne(String nom,String prenom, String mdp, String dateNaiss, String adresse, String mail){
	this.nom = nom;
	this.prenom = prenom;
	this.mdp = mdp;
	this.adresse = adresse;
	this.dateNaiss=dateNaiss;
	this.mail=mail;

// création de la personne dans la BDD
}

public void connect(){
// A creer
}
public void calcMoyMat (){
// A creer
}
public void calcMoyTri(){
// A creer
}
public void calcMoy(){
// A creer
}
public void afficheClasse(){
// A creer
}
public void afficheProfs(){
// A creer
}
public void afficheProfPrincipal(){
// A creer
	}

public String getNom(){return this.nom;
}
public String getPrenom(){return this.prenom;
}
public String getMdp(){return this.mdp;
}
public String getDateNaiss(){return this.dateNaiss;
}
public String getAdresse(){return this.adresse;
}
public String getMail(){return this.mail;
}


public void setNom(String nom){this.nom=nom;
}
public void setPrenom(String prenom){this.prenom=prenom;
}
public void setMdp(String mdp){this.mdp=mdp;
}
public void setDateNaiss(String dateNaiss){this.dateNaiss=dateNaiss;
}
public void setAdresse(String adresse){this.adresse=adresse;
}

}
