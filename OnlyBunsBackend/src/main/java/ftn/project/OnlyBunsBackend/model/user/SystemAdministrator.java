package ftn.project.OnlyBunsBackend.model.user;

import java.util.Set;

import ftn.project.OnlyBunsBackend.model.address.Address;

public class SystemAdministrator extends User {
	public SystemAdministrator() {
		super();
	}

	public SystemAdministrator(long id, boolean isEnabled, Set<UserRole> roles, String username, 
			String password, String emailAddress, String firstName, String lastName, 
			Address residenceAddress) {
		super(id, isEnabled, roles, username, password, emailAddress, firstName, lastName, 
				residenceAddress);
	}
}
