package com.may.the.fourth.be.with.you.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.may.the.fourth.be.with.you.model.Campaign;
import com.may.the.fourth.be.with.you.repository.CampaignsRepository;

@Service
public class CampaignService {

	@Autowired
	private CampaignsRepository campaignsRepository;

	public void create(Campaign campaign) {
		campaignsRepository.save(campaign);
	}

	public Campaign read(String id) {
		return campaignsRepository.findById(id).orElse(null);
	}

	public void update(Campaign user) {
		campaignsRepository.save(user);
	}

	public void delete(String id) {
		Campaign campaing = read(id);
		if (campaing != null) {
			campaignsRepository.delete(campaing);
		}
	}
	
	public Iterable<Campaign> findAll() {
		return campaignsRepository.findAll();
	}

}
