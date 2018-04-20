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
	
	@Column(name = "URL_IMAGE")
	private String urlImage;
	
	@Column(name = "SCORE")
	private Integer score;

	public Collegue() {
		// Constructeur vide
	}

	/** Constructor
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param urlImage
	 * @param score
	 */
	public Collegue(Integer id, String nom, String prenom, String urlImage, Integer score) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.urlImage = urlImage;
		this.score = score;
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
		
}
