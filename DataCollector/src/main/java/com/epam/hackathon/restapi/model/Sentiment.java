package com.epam.hackathon.restapi.model;

import java.util.ArrayList;

public class Sentiment {

	Subject subject;
	ArrayList<Polarity> polarities = new ArrayList<Polarity>();

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public ArrayList<Polarity> getPolarities() {
		return polarities;
	}

	public void setPolarities(ArrayList<Polarity> polarities) {
		this.polarities = polarities;
	}
}