package com.voteme.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("3")
public class CommentMark extends Mark {

	@ManyToOne
	@JoinColumn(name = "comment_id")
	@JsonIgnoreProperties(value = {"opinions", "marks", "author", "comments"})
	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
