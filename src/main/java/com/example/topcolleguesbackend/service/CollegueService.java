package com.example.topcolleguesbackend.service;

import com.example.topcolleguesbackend.entite.Avis;

/**
 * @author Emmanuel
 *
 */
public class CollegueService {

	public static Integer getResultat(Avis avis) {
		
		int score = 0;

		if (avis.equals(Avis.AIMER)) {
			
			score = 10;
			
		} else if (avis.equals(Avis.DETESTER)) {
			
			score = -5;
			
		}

		return score;
	}
}
