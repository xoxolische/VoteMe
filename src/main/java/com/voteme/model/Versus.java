package com.voteme.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "versus")
public class Versus {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;

	@OneToMany(mappedBy = "versus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "versus" })
	private Set<Opinion> opinions;

	@OneToMany(mappedBy = "versus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "versus", "user" })
	private Set<VersusMark> marks;

	@ManyToOne
	@JoinColumn(name = "author_id")
	@JsonIgnoreProperties(value = { "marks", "versuses", "role" })
	private User author;
	
	@JsonIgnore
	@OneToMany(mappedBy = "versus", fetch = FetchType.EAGER)
	private Set<Comment> comments;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Set<VersusMark> getMarks() {
		return marks;
	}

	public void setMarks(Set<VersusMark> marks) {
		this.marks = marks;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Set<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(Set<Opinion> opinions) {
		for (Opinion o : opinions) {
			o.setVersus(this);
		}
		this.opinions = opinions;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	
}
