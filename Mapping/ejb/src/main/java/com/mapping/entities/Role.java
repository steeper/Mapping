package com.mapping.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROL_ID")
	private int rolId;

	
	@Column(name="ROL_CREATION_DATE")
	private Date rolCreationDate;

	@Column(name="ROL_NAME")
	private String rolName;

	@Column(name="ROL_STATE")
	private String rolState;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;

	public Role() {
	}

	public int getRolId() {
		return this.rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public Date getRolCreationDate() {
		return this.rolCreationDate;
	}

	public void setRolCreationDate(Date rolCreationDate) {
		this.rolCreationDate = rolCreationDate;
	}

	public String getRolName() {
		return this.rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public String getRolState() {
		return this.rolState;
	}

	public void setRolState(String rolState) {
		this.rolState = rolState;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRole(null);

		return userRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rolId;
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
		Role other = (Role) obj;
		if (rolId != other.rolId)
			return false;
		return true;
	}
	
	

}