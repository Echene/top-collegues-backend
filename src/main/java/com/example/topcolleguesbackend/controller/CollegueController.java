package com.example.topcolleguesbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.entite.Vote;
import com.example.topcolleguesbackend.repository.CollegueRepository;
import com.example.topcolleguesbackend.service.CollegueService;

/**
 * @author Emmanuel
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class CollegueController {

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

}
