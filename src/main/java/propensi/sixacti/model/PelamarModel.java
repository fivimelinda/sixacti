package propensi.sixacti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pelamar")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class PelamarModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelamar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private UserModel userPelamar;

    @OneToOne(mappedBy = "pelamar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private LamaranModel lamaran;

    @OneToOne(mappedBy = "pelamarTesTulis", cascade = CascadeType.ALL)
    private TesTulisModel tesTulis;

    @OneToOne(mappedBy = "pelamarTesMedis", cascade = CascadeType.ALL)
    private TesMedisModel tesMedis;

    @OneToOne(mappedBy = "pelamarTesWawancara", cascade = CascadeType.ALL)
    private TesWawancaraModel tesWawancara;

    // @OneToOne(mappedBy = "pelamarAtribut", cascade = CascadeType.ALL)
    // @JsonIgnore
    // private AtributModel atribut;

    // /**
    // //  * @param atribut the atribut to set
    //  */
    // public void setAtribut(AtributModel atribut) {
    //     this.atribut = atribut;
    // }

    // /**
    //  * @return the atribut
    //  */
    // public AtributModel getAtribut() {
    //     return atribut;
    // }
    
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

    // /**
    //  * @return the tesMedis
    //  */
    // public TesMedisModel getTesMedis() {
    //     return tesMedis;
    // }

    /**
     * @param tesMedis the tesMedis to set
     */
    public void setTesMedis(TesMedisModel tesMedis) {
        this.tesMedis = tesMedis;
    }

    // /**
    //  * @return the tesTulis
    //  */
    // public TesTulisModel getTesTulis() {
    //     return tesTulis;
    // }

    /**
     * @param tesTulis the tesTulis to set
     */
    public void setTesTulis(TesTulisModel tesTulis) {
        this.tesTulis = tesTulis;
    }

    // /**
    //  * @return the tesWawancara
    //  */
    // public TesWawancaraModel getTesWawancara() {
    //     return tesWawancara;
    // }

    /**
     * @param tesWawancara the tesWawancara to set
     */
    public void setTesWawancara(TesWawancaraModel tesWawancara) {
        this.tesWawancara = tesWawancara;
    }

    // /**
    //  * @return the lamaran
    //  */
    // public LamaranModel getLamaran() {
    //     return lamaran;
    // }

    // /**
    //  * @param lamaran the lamaran to set
    //  */
    // public void setLamaran(LamaranModel lamaran) {
    //     this.lamaran = lamaran;
    // }


    /**
     * @return the lamaran
     */
    public LamaranModel getLamaran() {
        return lamaran;
    }

    /**
     * @param lamaran the lamaran to set
     */
    public void setLamaran(LamaranModel lamaran) {
        this.lamaran = lamaran;
    }
}