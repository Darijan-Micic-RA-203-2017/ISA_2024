package ftn.project.OnlyBunsBackend.model.post;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ftn.project.OnlyBunsBackend.model.user.User;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@SequenceGenerator(name = "comment_id_generator", sequenceName = "comment_ids_sequence", 
		initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_generator")
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
	private long id;

	@Column(name = "content", nullable = false, columnDefinition = "text")
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "creation_time", nullable = false)
	private Timestamp creationTime;

	public Comment() {}

	public Comment(long id, String content, Post post, User user, Timestamp creationTime) {
		this.id = id;
		this.content = content;
		this.post = post;
		this.user = user;
		this.creationTime = creationTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
}
