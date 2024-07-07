package com.demo.se104.footballLeagueManager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.se104.footballLeagueManager.model.Admin;
import com.demo.se104.footballLeagueManager.model.Regulation;
import com.demo.se104.footballLeagueManager.model.Team;
import com.demo.se104.footballLeagueManager.service.RegulationService;
import com.demo.se104.footballLeagueManager.service.TeamService;

@Controller
@RequestMapping("/admin")
public class RegulationController {

	private RegulationService regulationService;

	public RegulationController(RegulationService regulationService) {
		this.regulationService = regulationService;
	}
	
	@GetMapping("/regulations")
	public String listRegulation(Model theModel) {
		
		List<Regulation> regulations = regulationService.findAll();
		
		Regulation theRegulation = new Regulation();
		
		// add to the spring model
		theModel.addAttribute("regulation", regulations.get(0));
		theModel.addAttribute("theRegulation", theRegulation);
		return "regulation";
	}
	
	@PostMapping("/regulations")
	public String saveAdmin(@ModelAttribute("theRegulation") Regulation regulation, Model model) {
	    System.out.println(regulation.getId());
	    
	    if (regulation.getId() != null) {
	    	Regulation existingRegulation = regulationService.findById(regulation.getId());
	        if (existingRegulation != null) {
	        	existingRegulation.setMinAge(regulation.getMinAge());
	        	existingRegulation.setMaxAge(regulation.getMaxAge());
	        	existingRegulation.setMinNumber(regulation.getMinNumber());
	        	existingRegulation.setMaxNumber(regulation.getMaxNumber());
	        	existingRegulation.setMaxForeignNumber(regulation.getMaxForeignNumber());
	        	existingRegulation.setWinPoint(regulation.getWinPoint());
	        	existingRegulation.setDrawPoint(regulation.getDrawPoint());
	        	existingRegulation.setLossPoint(regulation.getLossPoint());
	        	existingRegulation.setMaxScoreTime(regulation.getMaxScoreTime());
	        	existingRegulation.setNumberOfGoalType(regulation.getNumberOfGoalType());
	        	existingRegulation.setRankingOrder(regulation.getRankingOrder());
	        	regulationService.save(existingRegulation);
	        }
	    }
	    return "redirect:/admin/regulations";
	}
}
