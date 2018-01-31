package com.voteme.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "opinion")
public class Opinion {

	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title", nullable = true)
	private String title;

	@Column(name = "text", nullable = true)
	private String text;

	@Column(name = "created_at")
	@CreationTimestamp
	private Timestamp createdAt;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "versus_id")
	private Versus versus;
	
	@OneToMany(mappedBy = "opinion")
	private Set<OpinionMark> marks;

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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Versus getVersus() {
		return versus;
	}

	public void setVersus(Versus versus) {
		this.versus = versus;
	}

	public Set<OpinionMark> getMarks() {
		return marks;
	}

	public void setMarks(Set<OpinionMark> marks) {
		this.marks = marks;
	}

}
