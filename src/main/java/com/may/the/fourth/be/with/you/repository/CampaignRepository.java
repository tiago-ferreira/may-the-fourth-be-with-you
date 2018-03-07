package com.may.the.fourth.be.with.you.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.may.the.fourth.be.with.you.model.Campaign;

public interface CampaignRepository extends MongoRepository<Campaign, String>{
	
	List<Campaign> findByBeginValidityLessThanEqualAndEndValidityGreaterThanEqual(LocalDate beginValidity, LocalDate endVAlidity);
	
	List<Campaign> findByBeginValidityAndEndValidity(LocalDate beginValidity, LocalDate endValidity);
	
}
