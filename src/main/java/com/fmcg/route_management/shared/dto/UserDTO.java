package com.fmcg.route_management.shared.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;


public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String login;
	private String firstName;
	private String lastName;
	private String email;
	private String imageUrl;
	private boolean activated = false;
	private String langKey;
	private String createdBy;
	private Instant createdDate;
	private String lastModifiedBy;
	private Instant lastModifiedDate;
	private Set<String> authorities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getLangKey() {
		return langKey;
	}

	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Set<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof UserDTO)) {
			return false;
		}

		return id != null && id.equals(((UserDTO) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "UserDTO{" + "login='" + login + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", email='" + email + '\'' + ", imageUrl='" + imageUrl + '\'' + ", activated=" + activated
				+ ", langKey='" + langKey + '\'' + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastModifiedBy='" + lastModifiedBy + '\'' + ", lastModifiedDate=" + lastModifiedDate
				+ ", authorities=" + authorities + "}";
	}
}
