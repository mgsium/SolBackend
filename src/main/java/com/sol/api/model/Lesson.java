package com.sol.api.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Table(name = "lesson")
public class Lesson {

	@Id
	@Column(name="ID")
	private String id;
	@Field(name="header")
	@Column(name="HEADER") 
	private String header;
	@Column(name="VIDEO_URL")
	private String video_url;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="AUTHOR_NAME")
	private String author_name;
	@Column(name="MORE_INFO")
	private String more_info;
	@Column(name="TIMESTAMP")
	private Timestamp timestamp;
	@ContainedIn
	@OneToMany(mappedBy="lesson", fetch = FetchType.EAGER)
	private List<Question> questions;
	
	public Lesson() {}
	
	public Lesson(String id, String header, String video_url, String description, String author_name, String more_info,
			Timestamp timestamp, List<Question> questions) {
		super();
		this.id = id;
		this.header = header;
		this.video_url = video_url;
		this.description = description;
		this.author_name = author_name;
		this.more_info = more_info;
		this.timestamp = timestamp;
		this.questions = questions;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the video_url
	 */
	public String getVideo_url() {
		return video_url;
	}
	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}


	/**
	 * @param header the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}


	/**
	 * @param video_url the video_url to set
	 */
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the author_name
	 */
	public String getAuthor_name() {
		return author_name;
	}
	/**
	 * @param author_name the author_name to set
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	/**
	 * @return the more_info
	 */
	public String getMore_info() {
		return more_info;
	}
	/**
	 * @param more_info the more_info to set
	 */
	public void setMore_info(String more_info) {
		this.more_info = more_info;
	}
	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Lesson [id=" + id + ", video_url=" + video_url + ", description=" + description + ", author_name="
				+ author_name + ", more_info=" + more_info + ", questions=" + questions + "]";
	}
}
