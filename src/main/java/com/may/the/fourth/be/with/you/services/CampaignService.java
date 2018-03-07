package com.may.the.fourth.be.with.you.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.may.the.fourth.be.with.you.model.Campaign;
import com.may.the.fourth.be.with.you.repository.CampaignRepository;

@Service
public class CampaignService {

	@Autowired
	private CampaignRepository campaignsRepository;

	public void create(Campaign campaign) {
		campaign.setCreation(LocalDate.now());
		campaign.setAlteration(LocalDate.now());
		campaignsRepository.save(campaign);
	}

	public Campaign read(String id) {
		return campaignsRepository.findById(id).orElse(null);
	}

	public void update(Campaign campaign) {
		campaign.setAlteration(LocalDate.now());
		campaignsRepository.save(campaign);
	}

	public void delete(String id) {
		Campaign campaing = read(id);
		if (campaing != null) {
			campaignsRepository.delete(campaing);
		}
	}
	
	public List<Campaign> findActiveCampaigns() {
		return campaignsRepository.findByBeginValidityLessThanEqualAndEndValidityGreaterThanEqual(LocalDate.now(), LocalDate.now());
	}
	
	public Boolean hasCampaignInTheSamePeriod(LocalDate beginValidity, LocalDate endValidity) {
		List<Campaign> campaigns = campaignsRepository.findByBeginValidityAndEndValidity(beginValidity, endValidity);
		return (campaigns.size() > 0);
	}
	
}
