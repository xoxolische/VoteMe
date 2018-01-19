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
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "nick_name", nullable = false)
	private String nickName;

	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	@Column(name = "registered_at")
	@CreationTimestamp
	private Timestamp registeredAt;

	@Column(name = "last_edited_at")
	@UpdateTimestamp
	private Timestamp lastEditedAt;

	@OneToMany(mappedBy = "author")
	private Set<Opinion> opinions;
	
	@OneToMany(mappedBy = "user")
	private Set<Mark> marks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Timestamp registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Timestamp getLastEditedAt() {
		return lastEditedAt;
	}

	public void setLastEditedAt(Timestamp lastEditedAt) {
		this.lastEditedAt = lastEditedAt;
	}

	public Set<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(Set<Opinion> opinions) {
		this.opinions = opinions;
	}

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
