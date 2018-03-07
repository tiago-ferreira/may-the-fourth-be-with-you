package com.may.the.fourth.be.with.you.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.may.the.fourth.be.with.you.model.Campaign;

public interface CampaignRepository extends MongoRepository<Campaign, String>{
	
	@Query("{beginValidity:{$lte: ?0},endValidity:{$gte: ?1}}")
	List<Campaign> findActiveCampaigns(LocalDate beginValidity, LocalDate endValidity);
	
	List<Campaign> findByBeginValidityLessThanEqualAndEndValidityGreaterThanEqual(LocalDate beginValidity, LocalDate endVAlidity);
}
