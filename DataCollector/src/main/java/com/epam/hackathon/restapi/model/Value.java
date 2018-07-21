package com.epam.hackathon.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Value {

	private String display_value;
	private String relevancy;
	private String value;
	@JsonIgnore
	private String display_value_short;
	
	public String getDisplay_value_short() {
		return display_value_short;
	}

	public void setDisplay_value_short(String display_value_short) {
		this.display_value_short = display_value_short;
	}

	public String getDisplay_value() {
		return display_value;
	}

	public void setDisplay_value(String display_value) {
		this.display_value = display_value;
	}

	public String getRelevancy() {
		return relevancy;
	}

	public void setRelevancy(String relevancy) {
		this.relevancy = relevancy;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
