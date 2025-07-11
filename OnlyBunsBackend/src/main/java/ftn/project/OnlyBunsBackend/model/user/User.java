package ftn.project.OnlyBunsBackend.model.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ftn.project.OnlyBunsBackend.model.address.Address;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	@Id
	@SequenceGenerator(name = "user_id_generator", sequenceName = "user_ids_sequence", 
		initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
	protected long id;

	@Column(name = "is_enabled", nullable = false)
	protected boolean isEnabled;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles_join_table", 
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	protected Set<UserRole> roles;

	@Column(name = "username", nullable = false)
	protected String username;

	@JsonIgnore
	@Column(name = "password", nullable = false)
	protected String password;

	@Column(name = "email_address", nullable = false)
	protected String emailAddress;

	@Column(name = "first_name", nullable = false)
	protected String firstName;

	@Column(name = "last_name", nullable = false)
	protected String lastName;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "residence_address_id")
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
