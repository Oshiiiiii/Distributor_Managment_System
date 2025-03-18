package com.fmcg.route_management.io.entity;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A UserType.
 */
@Entity
@Table(name = "UserType")
public class UserType implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "user_type_name", length = 50, nullable = false)
    private String userTypeName;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "userType")
    private Set<User> users = new HashSet<>();


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}  

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserType)) {
            return false;
        }
        return id != null && id.equals(((UserType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }



    // prettier-ignore
    @Override
    public String toString() {
        return "UserType{" +
            "id=" + getId() +
            ", userTypeName='" + getUserTypeName() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
