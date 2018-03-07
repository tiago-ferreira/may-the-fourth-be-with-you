package com.may.the.fourth.be.with.you.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.may.the.fourth.be.with.you.model.Campaign;
import com.may.the.fourth.be.with.you.services.CampaignService;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create(@RequestBody Campaign campaign) {
		campaign.setValidity(LocalDate.now());
		campaignService.create(campaign);
	}

	@GetMapping(value = "/{id}")
	public Campaign read(@PathVariable("id") String id) {
		return campaignService.read(id);
	}

	@PutMapping()
	@ResponseBody
	public void update(@RequestBody Campaign user) {
		campaignService.update(user);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") String id) {
		campaignService.delete(id);
	}
	
	@GetMapping
	public Iterable<Campaign> findAll() {
		return campaignService.findAll();
	}

}
