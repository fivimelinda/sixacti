package propensi.sixacti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tesTulis")

public class TesTulisModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTesTulis;

    @NotNull
    @Size(max = 255)
    @Column(name = "nilai", nullable = false)
    private Integer nilai;

    // reference ke pelamar
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPelamar", referencedColumnName = "idPelamar")
    private PelamarModel pelamar;


    /**
     * @return the idTesTulis
     */
    public Long getIdTesTulis() {
        return idTesTulis;
    }

    /**
     * @param idTesTulis the idTesTulis to set
     */
    public void setIdTesTulis(Long idTesTulis) {
        this.idTesTulis = idTesTulis;
    }

    /**
     * @return the nilai
     */
    public Integer getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }
}