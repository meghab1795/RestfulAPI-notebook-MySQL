package com.notebook.restapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "notes")
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "tags")
	private String[] tags;
	@Column(name = "body")
	private String body;
	@Column(name = "created_timestamps")
	private Date createdTimestamps;
	@Column(name = "modified_timestamps")
	private Date modifiedTimestamps;
	
	
	public Notes() {
		super();
	}
	public Notes(long id, String title, String[] tags, String body, Date createdTimestamps, Date modifiedTimestamps) {
		super();
		this.id = id;
		this.title = title;
		this.tags = tags;
		this.body = body;
		this.createdTimestamps = createdTimestamps;
		this.modifiedTimestamps = modifiedTimestamps;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getCreatedTimestamps() {
		return createdTimestamps;
	}
	public void setCreatedTimestamps(Date createdTimestamps) {
		this.createdTimestamps = createdTimestamps;
	}
	public Date getModifiedTimestamps() {
		return modifiedTimestamps;
	}
	public void setModifiedTimestamps(Date modifiedTimestamps) {
		this.modifiedTimestamps = modifiedTimestamps;
	}
	
	

}
