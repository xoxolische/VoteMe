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

@Entity
@Table(name = "opinion")
public class Opinion {

	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "text")
	private String text;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "versus_id")
	private Versus versus;
	
	@OneToMany(mappedBy = "opinion")
	private Set<Mark> marks;

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

}