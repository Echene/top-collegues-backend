package com.example.topcolleguesbackend.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.entite.Vote;
import com.example.topcolleguesbackend.model.NewCollegue;
import com.example.topcolleguesbackend.repository.CollegueRepository;
import com.example.topcolleguesbackend.service.CollegueService;
import com.example.topcolleguesbackend.util.JsonReader;

/**
 * @author Emmanuel
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class CollegueController {

	private final String URL_COLLEGUES = "http://collegues-api.cleverapps.io/collegues?matricule=";
	
	@Autowired
	private CollegueRepository collegueRepository;

	@GetMapping
	public List<Collegue> listerCollegues() {
		return this.collegueRepository.findAll();
	}

	@PatchMapping("/{nomCollegue}")
	public Collegue updateAvis(@PathVariable(value = "nomCollegue") String nomCollegue, @RequestBody Vote vote) {

		Collegue collegue = new Collegue();

		if (collegueRepository.existsByNom(nomCollegue)) {

			collegue = this.collegueRepository.findByNom(nomCollegue);
			int score = collegue.getScore();

			if(score <= 1000 && score >= -1000) {
				collegue.setScore(collegue.getScore() + CollegueService.getResultat(vote.getAction()));
				
				collegueRepository.save(collegue);
			}
			
		}

		return collegue;
	}
	
	@GetMapping("/{nomCollegue}")
	public Collegue getCollegue(@PathVariable(value = "nomCollegue") String nomCollegue) {

		Collegue collegue = new Collegue();

		if (collegueRepository.existsByNom(nomCollegue)) {

			collegue = collegueRepository.findByNom(nomCollegue);
			
		}
		
		return collegue;
	}
	
	@PostMapping("/nouveau")
	public Collegue getCollegueFromForm(@RequestBody NewCollegue newCollegue) throws IOException, JSONException {

		Collegue collegue = JsonReader.getSingleCollegueFromJson(URL_COLLEGUES + newCollegue.getMatricule());
		
		if(collegue != null) {
			
			collegue.setNom(newCollegue.getNom());
			collegue.setPrenom(newCollegue.getPrenom());
			
			collegueRepository.save(collegue);
			
		}
		
		return collegue;
	}

}
