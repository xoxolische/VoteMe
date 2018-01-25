package com.voteme.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("1")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id", scope = VersusMark.class)
// @JsonIdentityReference(alwaysAsId = true)
public class VersusMark extends Mark {
	@ManyToOne
	@JoinColumn(name = "versus_id")
	@JsonIgnoreProperties(value = "marks")
	private Versus versus;

	public Versus getVersus() {
		return versus;
	}

	public void setVersus(Versus versus) {
		this.versus = versus;
	}

}
