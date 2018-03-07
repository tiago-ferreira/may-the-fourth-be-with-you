package com.may.the.fourth.be.with.you.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Campaign {

	@Id
	private String id;
	private String name;
	private String heartTeamId;
	private LocalDate creation;
	private LocalDate alteration;
	private LocalDate beginValidity;
	private LocalDate endValidity;

	public Campaign() {

	}

	public Campaign(String id, String name, String heartTeamId, LocalDate creation, LocalDate alteration,
			LocalDate beginValidity, LocalDate endValidity) {
		super();
		this.id = id;
		this.name = name;
		this.heartTeamId = heartTeamId;
		this.creation = creation;
		this.alteration = alteration;
		this.beginValidity = beginValidity;
		this.endValidity = endValidity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeartTeamId() {
		return heartTeamId;
	}

	public void setHeartTeamId(String heartTeamId) {
		this.heartTeamId = heartTeamId;
	}

	public LocalDate getCreation() {
		return creation;
	}

	public void setCreation(LocalDate creation) {
		this.creation = creation;
	}

	public LocalDate getAlteration() {
		return alteration;
	}

	public void setAlteration(LocalDate alteration) {
		this.alteration = alteration;
	}

	public LocalDate getBeginValidity() {
		return beginValidity;
	}

	public void setBeginValidity(LocalDate beginValidity) {
		this.beginValidity = beginValidity;
	}

	public LocalDate getEndValidity() {
		return endValidity;
	}

	public void setEndValidity(LocalDate endValidity) {
		this.endValidity = endValidity;
	}

}
