package com.epam.hackathon.restapi.model;

import java.util.ArrayList;

public class Sentiment {
	Subject SubjectObject;
	ArrayList<Polarity> polarities = new ArrayList<Polarity>();

	// Getter Methods

	public Subject getSubject() {
		return SubjectObject;
	}

	// Setter Methods

	public void setSubject(Subject subjectObject) {
		this.SubjectObject = subjectObject;
	}

	public class Subject {
		private String display_name;
		private String name;
		ArrayList<Object> values = new ArrayList<Object>();

		// Getter Methods

		public String getDisplay_name() {
			return display_name;
		}

		public String getName() {
			return name;
		}

		// Setter Methods

		public void setDisplay_name(String display_name) {
			this.display_name = display_name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}