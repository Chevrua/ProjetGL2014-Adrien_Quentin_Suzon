package org.ema.projectGL.metier;

public class Notes {
	protected int note;
	protected Matiere id_matiere;
	protected Eleves id_eleve;
	
//Chaque action doit avoir un impact dans la BDD

public Notes(int note){
	this.note = note;
}
	
public Notes(int note, Matiere id_matiere, Eleves id_eleve){
	this.note = note;
	this.id_matiere = id_matiere;
	this.id_eleve = id_eleve;
}
	
public int getNote(){return this.note;
}
public Matiere getId_Matiere(){return this.id_matiere;
}
public Eleves getId_Eleve(){return this.id_eleve;
}
public void setNote(int note){this.note = note;
}
public void setId_Matiere(Matiere id_matiere){this.id_matiere=id_matiere;
}
public void setId_eleve(Eleves id_eleve){this.id_eleve = id_eleve;
}
}
