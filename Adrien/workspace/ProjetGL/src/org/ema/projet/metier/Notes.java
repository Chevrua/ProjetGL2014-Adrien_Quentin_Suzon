package org.ema.projet.metier;

public class Notes {
	private int note;
	private Matiere idMatiere;
	private Eleves idEleve;
	
//Chaque action doit avoir un impact dans la BDD

public Notes(int note){
	this.note = note;
}
	
public Notes(int note, Matiere idMatiere, Eleves idEleve){
	this.note = note;
	this.idMatiere = idMatiere;
	this.idEleve = idEleve;
}
	
public int getNote(){return this.note;
}
public Matiere getIdMatiere(){return this.idMatiere;
}
public Eleves getIdEleve(){return this.idEleve;
}
public void setNote(int note){this.note = note;
}
public void setIdMatiere(Matiere idMatiere){this.idMatiere=idMatiere;
}
public void setIdEleve(Eleves idEleve){this.idEleve = idEleve;
}
}
