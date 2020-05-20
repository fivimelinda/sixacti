package propensi.sixacti.payload.request;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private List<String> role;

    // private String departement;

    // private String section;
  
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

}