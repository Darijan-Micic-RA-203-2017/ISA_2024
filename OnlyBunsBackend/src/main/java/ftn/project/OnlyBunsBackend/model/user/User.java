package ftn.project.OnlyBunsBackend.model.user;

import java.util.Set;

import ftn.project.OnlyBunsBackend.model.address.Address;

public abstract class User {
	protected long id;
	protected boolean isEnabled;
	protected Set<UserRole> roles;
	protected String username;
	protected String password;
	protected String emailAddress;
	protected String firstName;
	protected String lastName;
	protected Address residenceAddress;

	public User() {}

	public User(long id, boolean isEnabled, Set<UserRole> roles, String username, String password, 
			String emailAddress, String firstName, String lastName, Address residenceAddress) {
		this.id = id;
		this.isEnabled = isEnabled;
		this.roles = roles;
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

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
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
