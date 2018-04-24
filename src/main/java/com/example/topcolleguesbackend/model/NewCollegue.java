package com.example.topcolleguesbackend.model;

import com.example.topcolleguesbackend.entite.Collegue;

/**
 * @author Emmanuel
 *
 */
public class NewCollegue extends Collegue {

	private String matricule;
	private String password;
	
	public NewCollegue(String matricule, String password) {
		super();
		this.matricule = matricule;
		this.password = password;
	}
	
	public NewCollegue() {
		// Constructeur vide
	}

	/** Getter
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/** Getter
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/** Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/** Setter
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
