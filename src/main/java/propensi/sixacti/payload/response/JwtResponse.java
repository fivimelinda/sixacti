package propensi.sixacti.payload.response;

import java.util.List;
import java.util.Set;

import propensi.sixacti.model.UserModel;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private List<String> role;
	private UserModel user;
    // private String departement;
    // private String section;

	public JwtResponse(String accessToken, Long id, String username, List<String> role, UserModel user) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.role = role;
		this.user = user;
        // this.departement = departement;
        // this.section = section;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
     * @param role the role to set
     */
    public void setRole(List<String> role) {
        this.role = role;
    }

    /**
     * @return the role
     */
    public List<String> getRole() {
        return role;
    }
	
	/**
	 * @return the users
	 */
	public UserModel getUser() {
		return user;
	}

	/**
	 * @param users the users to set
	 */
	public void setUser(UserModel user) {
		this.user = user;
	}

}