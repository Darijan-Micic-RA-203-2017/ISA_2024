package ftn.project.OnlyBunsBackend.model.user;

import java.util.Set;

import ftn.project.OnlyBunsBackend.model.address.Address;

public abstract class User {
	protected long id;
	protected Set<UserRole> roles;
	protected boolean isEnabled;
	protected String username;
	protected String password;
	protected String emailAddress;
	protected String firstName;
	protected String lastName;
	protected Address residenceAddress;

	public User() {}

	public User(long id, Set<UserRole> roles, boolean isEnabled, String username, String password, 
			String emailAddress, String firstName, String lastName, Address residenceAddress) {
		this.id = id;
		this.roles = roles;
		this.isEnabled = isEnabled;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.residenceAddress = residenceAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public Address getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(Address residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
}
