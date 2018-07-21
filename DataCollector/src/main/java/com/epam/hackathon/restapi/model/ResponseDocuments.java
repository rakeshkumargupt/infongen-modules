package com.epam.hackathon.restapi.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseDocuments {
	
	List<Document> documents = new ArrayList<Document>();
	private float documents_total;


	 // Getter Methods 

	  public float getDocuments_total() {
	    return documents_total;
	  }

	 // Setter Methods 

	  public void setDocuments_total( float documents_total ) {
	    this.documents_total = documents_total;
	  }
}
