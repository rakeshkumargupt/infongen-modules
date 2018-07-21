package com.epam.hackathon.restapi.model;

import java.util.ArrayList;
import java.util.List;

public class Document {

	private String category;
	private String contributor;
	private String id;
	private String uri;
	private String image_uri;
	private String published_at;
	List<Sentiment> sentiments = new ArrayList<Sentiment>();
	private String source;
	private String summary;
	ArrayList<Tag> tags = new ArrayList<Tag>();
	private String headline;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getImage_uri() {
		return image_uri;
	}

	public void setImage_uri(String image_uri) {
		this.image_uri = image_uri;
	}

	public String getPublished_at() {
		return published_at;
	}

	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}

	public List<Sentiment> getSentiments() {
		return sentiments;
	}

	public void setSentiments(List<Sentiment> sentiments) {
		this.sentiments = sentiments;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Override
	public String toString() {
		return "Document [category=" + category + ", contributor=" + contributor + ", id=" + id + ", uri=" + uri
				+ ", image_uri=" + image_uri + ", published_at=" + published_at + ", sentiments=" + sentiments
				+ ", source=" + source + ", summary=" + summary + ", tags=" + tags + ", headline=" + headline + "]";
	}

}
