package propensi.sixacti.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "pelamar")

public class PelamarModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelamar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private UserModel userPelamar;

    /**
     * @param idPelamar the idPelamar to set
     */
    public void setIdPelamar(Long idPelamar) {
        this.idPelamar = idPelamar;
    }

    /**
     * @return the idPelamar
     */
    public Long getIdPelamar() {
        return idPelamar;
    }

    /**
     * @param userPelamar the userPelamar to set
     */
    public void setUserPelamar(UserModel userPelamar) {
        this.userPelamar = userPelamar;
    }

    /**
     * @return the userPelamar
     */
    public UserModel getUserPelamar() {
        return userPelamar;
    }
}