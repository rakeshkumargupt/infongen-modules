package com.epam.hackathon.restapi.model;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private String display_name;
	private String name;
	List<SubjectValue> values = new ArrayList<SubjectValue>();
	
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SubjectValue> getValues() {
		return values;
	}
	public void setValues(List<SubjectValue> values) {
		this.values = values;
	}

	
}
