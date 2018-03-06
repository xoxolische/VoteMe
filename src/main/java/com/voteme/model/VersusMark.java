package com.voteme.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("1")
public class VersusMark extends Mark {
	@ManyToOne
	@JoinColumn(name = "versus_id")
	@JsonIgnoreProperties(value = {"marks", "opinions", "title", "description", "createdAt", "author", "comments"})
	private Versus versus;

	public Versus getVersus() {
		return versus;
	}

	public void setVersus(Versus versus) {
		this.versus = versus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((versus == null) ? 0 : versus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersusMark other = (VersusMark) obj;
		if (versus == null) {
			if (other.versus != null)
				return false;
		} else if (!versus.equals(other.versus))
			return false;
		return true;
	}

}
