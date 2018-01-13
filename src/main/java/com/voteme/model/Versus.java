package com.voteme.model;

public class Versus {

	private long id;

	private String title;

	private String description;

	private Opinion opinion1;

	private Opinion opinion2;

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

	public Opinion getOpinion1() {
		return opinion1;
	}

	public void setOpinion1(Opinion opinion1) {
		this.opinion1 = opinion1;
	}

	public Opinion getOpinion2() {
		return opinion2;
	}

	public void setOpinion2(Opinion opinion2) {
		this.opinion2 = opinion2;
	}

}
