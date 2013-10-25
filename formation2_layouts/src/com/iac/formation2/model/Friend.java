package com.iac.formation2.model;

import java.io.Serializable;

public class Friend  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	String nom;
	String prenom;
	String atelier;
	Boolean isStaff;
	
	
	public Friend(String nom, String prenom, String atelier, Boolean isStaff) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.atelier = atelier;
		this.isStaff = isStaff;
	}
	
	public Friend(){
	}

	//getters and setters
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAtelier() {
		return atelier;
	}

	public void setAtelier(String atelier) {
		this.atelier = atelier;
	}

	public Boolean getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
	}

	
	
	
	
}
