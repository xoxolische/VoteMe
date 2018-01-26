package com.voteme.model;

import java.sql.Timestamp;
import java.util.Set;

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

	@ManyToOne
	@JoinColumn(name = "versus_id")
	private Versus versus;

	@OneToMany(mappedBy = "opinion", fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = {"opinion", "user"})
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

	public Set<OpinionMark> getMarks() {
		return marks;
	}

	public void setMarks(Set<OpinionMark> marks) {
		this.marks = marks;
	}

	public Versus getVersus() {
		return versus;
	}

	public void setVersus(Versus versus) {
		this.versus = versus;
	}

}
