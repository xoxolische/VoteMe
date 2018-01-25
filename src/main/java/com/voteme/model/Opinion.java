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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "opinion")
public class Opinion {

	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "text", nullable = true)
	private String text;

	@Column(name = "created_at")
	@CreationTimestamp
	private Timestamp createdAt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "versus_id")
	@JsonIgnore
	private Versus versus;
	
	@OneToMany(mappedBy = "opinion")
	@JsonIgnoreProperties(value = "opinion")
	private Set<OpinionMark> marks;

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
