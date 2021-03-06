package propensi.sixacti.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username")
})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 255)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usersRoles",
    joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Roles> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private UserModel user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    @JsonIgnore
    private List<RequestLowonganModel> requestLowongan;


    public Users(){

    }

    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the roles
     */
    public Set<Roles> getRoles() {
        return roles;
    }
    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    /**
     * @return the user
     */
    public UserModel getUser() {
        return user;
    }
    /**
     * @param user the user to set
     */
    public void setUser(UserModel user) {
        this.user = user;
    }
}