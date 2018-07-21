package com.epam.hackathon.restapi.model;

import java.util.ArrayList;

public class Document {

	 private String category;
	  private String contributor;
	  private String id;
	  private String uri;
	  private String image_uri;
	  private String published_at;
	  ArrayList<Object> sentiments = new ArrayList<Object>();
	  private String source;
	  private String summary;
	  ArrayList<Object> tags = new ArrayList<Object>();
	  private String headline;


	 // Getter Methods 

	  public String getCategory() {
	    return category;
	  }

	  public String getContributor() {
	    return contributor;
	  }

	  public String getId() {
	    return id;
	  }

	  public String getUri() {
	    return uri;
	  }

	  public String getImage_uri() {
	    return image_uri;
	  }

	  public String getPublished_at() {
	    return published_at;
	  }

	  public String getSource() {
	    return source;
	  }

	  public String getSummary() {
	    return summary;
	  }

	  public String getHeadline() {
	    return headline;
	  }

	 // Setter Methods 

	  public void setCategory( String category ) {
	    this.category = category;
	  }

	  public void setContributor( String contributor ) {
	    this.contributor = contributor;
	  }

	  public void setId( String id ) {
	    this.id = id;
	  }

	  public void setUri( String uri ) {
	    this.uri = uri;
	  }

	  public void setImage_uri( String image_uri ) {
	    this.image_uri = image_uri;
	  }

	  public void setPublished_at( String published_at ) {
	    this.published_at = published_at;
	  }

	  public void setSource( String source ) {
	    this.source = source;
	  }

	  public void setSummary( String summary ) {
	    this.summary = summary;
	  }

	  public void setHeadline( String headline ) {
	    this.headline = headline;
	  }
}
