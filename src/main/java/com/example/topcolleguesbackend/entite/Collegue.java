package com.example.topcolleguesbackend.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Emmanuel
 *
 */

@Entity
@Table(name = "COLLEGUE")
public class Collegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "PRENOM")
	private String prenom;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ADRESSE")
	private String adresse;
	
	@Column(name = "URL_IMAGE")
	private String urlImage;
	
	@Column(name = "SCORE")
	private Integer score;

	/** Constructor
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 * @param urlImage
	 * @param score
	 */
	public Collegue(String nom, String prenom, String email, String adresse, String urlImage, Integer score) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.urlImage = urlImage;
		this.score = score;
	}
	
	public Collegue(String nom, String prenom, String urlImage, Integer score) {
		this.nom = nom;
		this.prenom = prenom;
		this.urlImage = urlImage;
		this.score = score;
	}

	/** Constructor
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 * @param urlImage
	 */
	public Collegue(String nom, String prenom, String email, String adresse, String urlImage) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.urlImage = urlImage;
	}

	public Collegue() {
		// Constructeur vide
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Collegue [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse="
				+ adresse + ", urlImage=" + urlImage + ", score=" + score + "]";
	}

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Getter
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}

	/** Getter
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Setter
	 * @param urlImage the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	/** Setter
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		if(score > 1000) {
			
			this.score = 1000;
			
		} else if(score < -1000) {
			
			this.score = -1000;
			
		} else {
			
			this.score = score;
			
		}	
	}

	/** Getter
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/** Getter
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
		
}
