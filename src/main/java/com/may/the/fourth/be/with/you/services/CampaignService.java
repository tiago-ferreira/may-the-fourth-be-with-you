package com.may.the.fourth.be.with.you.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.may.the.fourth.be.with.you.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.may.the.fourth.be.with.you.model.Campaign;
import com.may.the.fourth.be.with.you.repository.CampaignRepository;

@Service
public class CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;

	public void create(Campaign campaign) {
		Boolean hasCampaignInTheSamePeriodo = hasCampaignInTheSamePeriod(campaign.getBeginValidity(), campaign.getEndValidity());
		if(hasCampaignInTheSamePeriodo) {
			modifyCampaignPeriod(campaign);
		}
		campaign.setCreation(LocalDate.now());
		campaign.setAlteration(LocalDate.now());
		campaignRepository.save(campaign);
	}

	private void modifyCampaignPeriod(Campaign campaignToCreate) {
		List<Campaign> campaigns = findActiveCampaigns();
		for(Campaign campaign : campaigns) {
			campaign.setEndValidity(campaign.getEndValidity().plusDays(1));
			while(hasCampaignInTheSamePeriod(campaign.getBeginValidity(), campaign.getEndValidity()) 
					|| hasTheSamePeriod(campaign, campaignToCreate)) {
				campaign.setEndValidity(campaign.getEndValidity().plusDays(1));
				
			}
			campaign.setAlteration(LocalDate.now());
			campaignRepository.save(campaign);
		}
	}
	
	private Boolean hasTheSamePeriod(Campaign c1, Campaign c2) {
		return c1.getBeginValidity().equals(c2.getBeginValidity()) && c1.getEndValidity().equals(c2.getEndValidity());
	}

	public Optional<Campaign> read(String id) {
		return campaignRepository.findById(id);
	}

	public void update(Campaign campaign) {
		campaign.setAlteration(LocalDate.now());
		campaignRepository.save(campaign);
	}

	public void delete(String id) {
		Optional<Campaign> campaing = read(id);
		if (campaing != null) {
			campaignRepository.delete(campaing.get());
		}
	}
	
	public List<Campaign> findActiveCampaigns() {
		return campaignRepository.findByBeginValidityLessThanEqualAndEndValidityGreaterThanEqual(LocalDate.now(), LocalDate.now());
	}
	
	public Boolean hasCampaignInTheSamePeriod(LocalDate beginValidity, LocalDate endValidity) {
		List<Campaign> campaigns = campaignRepository.findByBeginValidityAndEndValidity(beginValidity, endValidity);
		return (campaigns.size() > 0);
	}
	
	public List<Campaign> findActiveCampaignsByHeartTeamId(String heartTeamId) {
		return campaignRepository.findByBeginValidityLessThanEqualAndEndValidityGreaterThanEqualAndHeartTeamId(LocalDate.now(), LocalDate.now(), heartTeamId);
	}
	
}
