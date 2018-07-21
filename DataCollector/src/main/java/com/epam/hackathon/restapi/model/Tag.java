package com.epam.hackathon.restapi.model;

import java.util.ArrayList;
import java.util.List;

public class Tag {

	private String display_name;
	private String name;
	List<Value> values = new ArrayList<Value>();
	
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
	public List<Value> getValues() {
		return values;
	}
	public void setValues(List<Value> values) {
		this.values = values;
	}
	@Override
	public String toString() {
		return display_name;
	}

	 
}
