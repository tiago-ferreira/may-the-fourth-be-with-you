package com.may.the.fourth.be.with.you.controller;

import java.util.List;

import com.may.the.fourth.be.with.you.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.may.the.fourth.be.with.you.model.Campaign;
import com.may.the.fourth.be.with.you.services.CampaignService;

import javax.validation.Valid;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@Valid @RequestBody Campaign campaign) {
        campaignService.create(campaign);
    }

    @GetMapping(value = "/{id}")
    public Campaign read(@PathVariable("id") String id) {
        return campaignService.read(id).orElseThrow(() -> new ResourceNotFoundException("Campaign", "id", id));
    }

    @PutMapping()
    public void update(@RequestBody Campaign campaign) {
        campaignService.update(campaign);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") String id) {
        campaignService.read(id).orElseThrow(() -> new ResourceNotFoundException("Campaign", "id", id));
        campaignService.delete(id);
    }

    @GetMapping
    public List<Campaign> findActiveCampaigns() {
        return campaignService.findActiveCampaigns();
    }

    @PostMapping(value = "/hasCampaignInTheSamePeriodo")
    public Boolean hasCampaignInTheSamePeriod(@RequestBody Campaign campaign) {
        return campaignService.hasCampaignInTheSamePeriod(campaign.getBeginValidity(), campaign.getEndValidity());
    }


    @GetMapping(value = "heartTeam/{heartTeamId}")
    public List<Campaign> findByHeartTeamId(@PathVariable("heartTeamId") String heartTeamId) {
        return campaignService.findActiveCampaignsByHeartTeamId(heartTeamId);
    }

}
