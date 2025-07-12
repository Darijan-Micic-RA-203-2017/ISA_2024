package ftn.project.OnlyBunsBackend.model.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import ftn.project.OnlyBunsBackend.model.address.Address;
import ftn.project.OnlyBunsBackend.model.chat.Chat;
import ftn.project.OnlyBunsBackend.model.post.Post;

@Entity
@Table(name = "basic_users")
public class BasicUser extends User {
	public BasicUser() {
		super();
	}

	public BasicUser(long id, boolean isEnabled, Set<UserRole> roles, String username, 
			String password, String emailAddress, String firstName, String lastName, 
			Address residenceAddress, Set<User> followedUsers, long numberOfFollowedUsers, 
			Set<User> followingUsers, long numberOfFollowingUsers, Set<Post> createdPosts, 
			Set<Post> likedPosts, Set<Chat> chats) {
		super(id, isEnabled, roles, username, password, emailAddress, firstName, lastName, 
				residenceAddress, followedUsers, numberOfFollowedUsers, followingUsers, 
				numberOfFollowingUsers, createdPosts, likedPosts, chats);
	}
}
