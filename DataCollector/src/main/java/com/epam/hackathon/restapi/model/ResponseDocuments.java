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

	@Override
	public String toString() {
		return "ResponseDocuments [documents=" + documents + ", documents_total=" + documents_total
				+ ", getDocuments()=" + getDocuments() + ", getDocuments_total()=" + getDocuments_total()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public void setDocuments_total(float documents_total) {
		this.documents_total = documents_total;
	}

}
