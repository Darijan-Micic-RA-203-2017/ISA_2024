package ftn.project.OnlyBunsBackend.model.user;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ftn.project.OnlyBunsBackend.model.address.Address;
import ftn.project.OnlyBunsBackend.model.chat.Chat;
import ftn.project.OnlyBunsBackend.model.post.Post;

@Entity
@Table(name = "users")
public class User implements UserDetails {
	private static final long serialVersionUID = -407941114328952168L;

	@Id
	@SequenceGenerator(name = "user_id_generator", sequenceName = "user_ids_sequence", 
		initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
	private long id;

	@Column(name = "is_enabled", nullable = false)
	private boolean isEnabled;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles_join_table", 
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private Set<UserRole> roles;

	@Column(name = "username", nullable = false)
	private String username;

	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "time_when_password_was_reset", nullable = false)
	private Timestamp timeWhenPasswordWasReset;

	@Column(name = "email_address", nullable = false)
	private String emailAddress;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "residence_address_id")
	private Address residenceAddress;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_following_join_table", 
		joinColumns = {@JoinColumn(name = "follower_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "followed_id", referencedColumnName = "id")})
	private Set<User> followedUsers;

	@Column(name = "number_of_followed_users", nullable = false, columnDefinition = "bigserial")
	private long numberOfFollowedUsers;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_following_join_table", 
		joinColumns = {@JoinColumn(name = "followed_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "follower_id", referencedColumnName = "id")})
	private Set<User> followingUsers;

	@Column(name = "number_of_following_users", nullable = false, columnDefinition = "bigserial")
	private long numberOfFollowingUsers;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Post> createdPosts;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "post_likes_join_table", 
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")})
	private Set<Post> likedPosts;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_chats_join_table", 
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "chat_id", referencedColumnName = "id")})
	private Set<Chat> chats;

	public User() {}

	public User(long id, boolean isEnabled, Set<UserRole> roles, String username, String password, 
			Timestamp timeWhenPasswordWasReset, String emailAddress, String firstName, 
			String lastName, Address residenceAddress, Set<User> followedUsers, 
			long numberOfFollowedUsers, Set<User> followingUsers, long numberOfFollowingUsers, 
			Set<Post> createdPosts, Set<Post> likedPosts, Set<Chat> chats) {
		this.id = id;
		this.isEnabled = isEnabled;
		this.roles = roles;
		this.username = username;
		this.password = password;
		this.timeWhenPasswordWasReset = timeWhenPasswordWasReset;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.residenceAddress = residenceAddress;
		this.followedUsers = followedUsers;
		this.numberOfFollowedUsers = numberOfFollowedUsers;
		this.followingUsers = followingUsers;
		this.numberOfFollowingUsers = numberOfFollowingUsers;
		this.createdPosts = createdPosts;
		this.likedPosts = likedPosts;
		this.chats = chats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
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

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Timestamp currentTime = new Timestamp(new Date().getTime());
		setTimeWhenPasswordWasReset(currentTime);

		this.password = password;
	}

	public Timestamp getTimeWhenPasswordWasReset() {
		return timeWhenPasswordWasReset;
	}

	public void setTimeWhenPasswordWasReset(Timestamp timeWhenPasswordWasReset) {
		this.timeWhenPasswordWasReset = timeWhenPasswordWasReset;
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

	public Set<User> getFollowedUsers() {
		return followedUsers;
	}

	public void setFollowedUsers(Set<User> followedUsers) {
		this.followedUsers = followedUsers;
	}

	public long getNumberOfFollowedUsers() {
		return numberOfFollowedUsers;
	}

	public void setNumberOfFollowedUsers(long numberOfFollowedUsers) {
		this.numberOfFollowedUsers = numberOfFollowedUsers;
	}

	public Set<User> getFollowingUsers() {
		return followingUsers;
	}

	public void setFollowingUsers(Set<User> followingUsers) {
		this.followingUsers = followingUsers;
	}

	public long getNumberOfFollowingUsers() {
		return numberOfFollowingUsers;
	}

	public void setNumberOfFollowingUsers(long numberOfFollowingUsers) {
		this.numberOfFollowingUsers = numberOfFollowingUsers;
	}

	public Set<Post> getCreatedPosts() {
		return createdPosts;
	}

	public void setCreatedPosts(Set<Post> createdPosts) {
		this.createdPosts = createdPosts;
	}

	public Set<Post> getLikedPosts() {
		return likedPosts;
	}

	public void setLikedPosts(Set<Post> likedPosts) {
		this.likedPosts = likedPosts;
	}

	public Set<Chat> getChats() {
		return chats;
	}

	public void setChats(Set<Chat> chats) {
		this.chats = chats;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
