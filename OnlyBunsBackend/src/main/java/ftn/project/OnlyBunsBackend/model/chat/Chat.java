package ftn.project.OnlyBunsBackend.model.chat;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ftn.project.OnlyBunsBackend.model.user.User;

@Entity
@Table(name = "chats")
public class Chat {
	@Id
	@SequenceGenerator(name = "chat_id_generator", sequenceName = "chat_ids_sequence", 
		initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_id_generator")
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "bigserial")
	private long id;

	@Column(name = "title", nullable = false, columnDefinition = "text")
	private String title;

	@Column(name = "is_group_chat", nullable = false)
	private boolean isGroupChat;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_chat_creator_id")
	private User groupChatCreator;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_chats_join_table", 
		joinColumns = {@JoinColumn(name = "chat_id", referencedColumnName = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
	private Set<User> users;

	@Column(name = "number_of_users", nullable = false)
	private int numberOfUsers;

	@OneToMany(mappedBy = "chat", fetch = FetchType.LAZY)
	private Set<ChatMessage> messages;

	@Column(name = "creation_time", nullable = false)
	private Timestamp creationTime;

	public Chat() {}

	public Chat(long id, String title, boolean isGroupChat, User groupChatCreator, Set<User> users, 
			int numberOfUsers, Set<ChatMessage> messages, Timestamp creationTime) {
		this.id = id;
		this.title = title;
		this.isGroupChat = isGroupChat;
		this.groupChatCreator = groupChatCreator;
		this.users = users;
		this.numberOfUsers = numberOfUsers;
		this.messages = messages;
		this.creationTime = creationTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isGroupChat() {
		return isGroupChat;
	}

	public void setGroupChat(boolean isGroupChat) {
		this.isGroupChat = isGroupChat;
	}

	public User getGroupChatCreator() {
		return groupChatCreator;
	}

	public void setGroupChatCreator(User groupChatCreator) {
		this.groupChatCreator = groupChatCreator;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	public Set<ChatMessage> getMessages() {
		return messages;
	}

	public void setMessages(Set<ChatMessage> messages) {
		this.messages = messages;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
}
