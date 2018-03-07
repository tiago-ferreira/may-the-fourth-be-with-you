package com.may.the.fourth.be.with.you.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Campaign {

	@Id
	private String id;
	private String name;
	private String heartTeamId;
	private LocalDate validity;

	public Campaign() {

	}

	public Campaign(String id, String name, String heartTeamId, LocalDate validity) {
		super();
		this.id = id;
		this.name = name;
		this.heartTeamId = heartTeamId;
		this.validity = validity;
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

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}
}
