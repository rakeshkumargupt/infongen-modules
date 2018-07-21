package com.epam.hackathon.restapi.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseDocuments {

	List<Document> documents = new ArrayList<Document>();
	private float documents_total;

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public float getDocuments_total() {
		return documents_total;
	}

	public void setDocuments_total(float documents_total) {
		this.documents_total = documents_total;
	}

}
