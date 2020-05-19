//package propensi.sixacti.model;
//
//import java.io.Serializable;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name = "akun")
//
//public class AkunModel implements Serializable{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idAkun;
//
//    @NotNull
//    @Size(max = 50)
//    @Column(name = "username", nullable = false)
//    private String username;
//
//    @NotNull
//    @Size(max = 50)
//    @Column(name = "password", nullable = false)
//    private String password;
//    
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "akun")
//    @JsonIgnore
//    private UserModel user;
//
//
//    /**
//     * @return the idAkun
//     */
//    public Long getIdAkun() {
//        return idAkun;
//    }
//    /**
//     * @param idAkun the idAkun to set
//     */
//    public void setIdAkun(Long idAkun) {
//        this.idAkun = idAkun;
//    }
//    /**
//     * @return the username
//     */
//    public String getUsername() {
//        return username;
//    }
//    /**
//     * @param username the username to set
//     */
//    public void setUsername(String username) {
//        this.username = username;
//    }
//    /**
//     * @return the password
//     */
//    public String getPassword() {
//        return password;
//    }
//    /**
//     * @param password the password to set
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
