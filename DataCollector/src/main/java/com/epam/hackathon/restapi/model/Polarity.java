package com.epam.hackathon.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Polarity {

	private String polarity;
	@JsonIgnore
	private String aspects;
	

	public String getAspects() {
		return aspects;
	}

	public void setAspects(String aspects) {
		this.aspects = aspects;
	}

	public String getPolarity() {
		return polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

}
