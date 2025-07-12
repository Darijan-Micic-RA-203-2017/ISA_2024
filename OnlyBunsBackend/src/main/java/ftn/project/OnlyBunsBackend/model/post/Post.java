package ftn.project.OnlyBunsBackend.model.post;

import java.sql.Timestamp;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ftn.project.OnlyBunsBackend.model.address.Address;
import ftn.project.OnlyBunsBackend.model.user.User;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@SequenceGenerator(name = "post_id_generator", sequenceName = "post_ids_sequence", 
		initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_generator")
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
	private long id;

	@Column(name = "description", nullable = false, columnDefinition = "text")
	private String description;

	@Column(name = "photo_path", nullable = false, columnDefinition = "text")
	private String photoPath;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "post_likes_join_table", 
		joinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
	private Set<User> usersWhoLikedIt;

	@Column(name = "number_of_likes", nullable = false, columnDefinition = "bigserial")
	private long numberOfLikes;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private Set<Comment> comments;

	@Column(name = "creation_time", nullable = false)
	private Timestamp creationTime;

	public Post() {}

	public Post(long id, String description, String photoPath, Address address, User user, 
			Set<User> usersWhoLikedIt, long numberOfLikes, Set<Comment> comments, 
			Timestamp creationTime) {
		this.id = id;
		this.description = description;
		this.photoPath = photoPath;
		this.address = address;
		this.user = user;
		this.usersWhoLikedIt = usersWhoLikedIt;
		this.numberOfLikes = numberOfLikes;
		this.comments = comments;
		this.creationTime = creationTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<User> getUsersWhoLikedIt() {
		return usersWhoLikedIt;
	}

	public void setUsersWhoLikedIt(Set<User> usersWhoLikedIt) {
		this.usersWhoLikedIt = usersWhoLikedIt;
	}

	public long getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(long numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
}
