package ftn.project.OnlyBunsBackend.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class TokenBasedAuthentication extends AbstractAuthenticationToken {
	private static final long serialVersionUID = 4717484548331913697L;

	private String token;
	private final UserDetails principal;

	public TokenBasedAuthentication(UserDetails principal) {
		super(principal.getAuthorities());

		this.principal = principal;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}
}
