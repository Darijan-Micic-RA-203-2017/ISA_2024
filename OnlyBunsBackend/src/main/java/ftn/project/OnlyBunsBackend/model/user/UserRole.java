package ftn.project.OnlyBunsBackend.model.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_roles")
public class UserRole implements GrantedAuthority {
	private static final long serialVersionUID = -2348856153627702376L;

	@Id
	@SequenceGenerator(name = "user_role_id_generator", sequenceName = "user_role_ids_sequence", 
		initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_id_generator")
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
	private long id;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles_join_table", 
		joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
	private Set<User> users;

	@Column(name = "name", nullable = false)
	private String name;

	public UserRole() {}

	public UserRole(long id, Set<User> users, String name) {
		this.id = id;
		this.users = users;
		this.name = name;
	}

	@JsonIgnore
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	@Override
	public String getAuthority() {
		return name;
	}
}
