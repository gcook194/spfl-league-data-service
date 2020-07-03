package com.gavincook.lds.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gavincook.lds.dao.CompetitionRepository;
import com.gavincook.lds.model.Competition;
import com.gavincook.lds.model.LeagueListResponse;

@RestController
@RequestMapping("leagues")
public class LeagueController {
	
	private CompetitionRepository leagueRepo; 
	
	@Autowired
	public LeagueController(CompetitionRepository leagueRepo) {
		this.leagueRepo = leagueRepo;
	}

	@GetMapping
	public ResponseEntity<LeagueListResponse> getLeagues() {
		
		LeagueListResponse response = new LeagueListResponse();
		
		List<Competition> leagues = leagueRepo.findAll();
		
		if (leagues != null) {
			response.setLeagues(leagues);
			response.setResults(leagues.size());
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/{resourceId}")
	public ResponseEntity<LeagueListResponse> getLeague(@PathVariable Long resourceId) {
		
		LeagueListResponse response = new LeagueListResponse();
		
		List<Competition> leagues = leagueRepo.findByResourceId(resourceId);
		
		if (leagues != null) {
			response.setLeagues(leagues);
			response.setResults(leagues.size());
		}
		
		return ResponseEntity.ok().body(response);
	}

}
