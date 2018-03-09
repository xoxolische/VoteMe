package com.voteme.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuth implements UserDetails {
	private static final long serialVersionUID = -4145180594601547790L;

	private long id;

	private String username;

	private String password;

	private boolean isActive;

	private Role role;

	private boolean confirmed;

	public UserAuth(long id, String username, String password, boolean isActive, Role role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.role = role;
	}

	public UserAuth(User u) {
		if (u != null) {
			this.id = u.getId();
			this.username = u.getNickName();
			this.password = u.getPassword();
			this.isActive = true;
			this.role = u.getRole();
			this.confirmed = u.isIs_verified();
		}
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public long getId() {
		return id;
	}

	public void setPassword(String p) {
		this.password = p;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isActive;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(role.getName()));
	}

	@Override
	public String toString() {
		return "UserAuth [id=" + id + ", username=" + username + ", password=" + password + ", isActive=" + isActive
				+ ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAuth other = (UserAuth) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
