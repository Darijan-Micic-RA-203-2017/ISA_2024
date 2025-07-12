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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ftn.project.OnlyBunsBackend.model.address.Address;
import ftn.project.OnlyBunsBackend.model.chat.Chat;
import ftn.project.OnlyBunsBackend.model.post.Post;

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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_following_join_table", 
		joinColumns = {@JoinColumn(name = "follower_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "followed_id", referencedColumnName = "id")})
	protected Set<User> followedUsers;

	@Column(name = "number_of_followed_users", nullable = false, columnDefinition = "bigserial")
	protected long numberOfFollowedUsers;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_following_join_table", 
		joinColumns = {@JoinColumn(name = "followed_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "follower_id", referencedColumnName = "id")})
	protected Set<User> followingUsers;

	@Column(name = "number_of_following_users", nullable = false, columnDefinition = "bigserial")
	protected long numberOfFollowingUsers;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	protected Set<Post> createdPosts;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "post_likes_join_table", 
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")})
	protected Set<Post> likedPosts;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_chats_join_table", 
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "chat_id", referencedColumnName = "id")})
	protected Set<Chat> chats;

	public User() {}

	public User(long id, boolean isEnabled, Set<UserRole> roles, String username, String password, 
			String emailAddress, String firstName, String lastName, Address residenceAddress, 
			Set<User> followedUsers, long numberOfFollowedUsers, Set<User> followingUsers, 
			long numberOfFollowingUsers, Set<Post> createdPosts, Set<Post> likedPosts, 
			Set<Chat> chats) {
		this.id = id;
		this.isEnabled = isEnabled;
		this.roles = roles;
		this.username = username;
		this.password = password;
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
}
