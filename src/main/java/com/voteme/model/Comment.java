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
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "text", nullable = false)
	private String text;

	@Column(name = "created_at")
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(name = "last_edited_at")
	@UpdateTimestamp
	private Timestamp lastEditedAt;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "versus_id", nullable = false)
	@JsonIgnoreProperties(value = {"opinions", "marks", "author", "comments"})
	private Versus versus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnoreProperties(value = { "marks", "versuses", "role", "password", "email", "code", "lastEditedAt"  })
	private User author;

	@OneToMany(mappedBy = "comment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "comment", "user" })
	private Set<CommentMark> marks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getLastEditedAt() {
		return lastEditedAt;
	}

	public void setLastEditedAt(Timestamp lastEditedAt) {
		this.lastEditedAt = lastEditedAt;
	}

	public Versus getVersus() {
		return versus;
	}

	public void setVersus(Versus versus) {
		this.versus = versus;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Set<CommentMark> getMarks() {
		return marks;
	}

	public void setMarks(Set<CommentMark> marks) {
		this.marks = marks;
	}
	
	

}
