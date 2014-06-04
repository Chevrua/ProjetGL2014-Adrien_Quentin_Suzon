package org.ema.projetGL.metier;


public class Eleves extends Personne{
	protected Parent Mere;
	protected Parent Pere;
	protected Classe id_classe;
	
//Chaque action doit avoir un impact dans la BDD

public Eleves(){
	super();
// création de la personne dans la BDD
}

public Eleves (String nom,String prenom, String mdp, String dateNaiss, String adresse, String mail){
	super(nom,prenom,mdp,dateNaiss,adresse,mail);
// création de la personne dans la BDD
}
	
public Classe getId_Classe(){return this.id_classe;
}
public Parent getMere(){return this.Mere;
}
public Parent getPere(){return this.Pere;
}
public void setId_Classe(Classe id_classe){this.id_classe = id_classe;
}
public void setMere(Parent Mere){this.Mere = Mere;
}
public void setPere(Parent Pere){this.Pere = Pere;
}	
}
