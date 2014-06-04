package org.ema.projectGL.metier;


public class Eleves extends Personne{
	protected Parent parent;
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
public Parent getParent(){return this.parent;
}
public void setId_Classe(Classe id_classe){this.id_classe = id_classe;
}
public void setMere(Parent parent){this.parent = parent;
}	
}
