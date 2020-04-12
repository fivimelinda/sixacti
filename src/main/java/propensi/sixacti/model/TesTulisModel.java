package propensi.sixacti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tesTulis")

public class TesTulisModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTesTulis;

    @NotNull
    @Size(max = 255)
    @Column(name = "nilai", nullable = false)
    private String nilai;

    @NotNull
    @Column(name="isEdit", nullable=false)
    private Boolean isEdit;

    // reference ke pelamar
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPelamar", referencedColumnName = "idPelamar")
    @OnDelete(action= OnDeleteAction.CASCADE)
    // @JsonIgnore
    private PelamarModel pelamarTesTulis;

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
    public String getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public Boolean getIsEdit(){
        return isEdit;
    }

    public void setIsEdit(Boolean isEdit){
        this.isEdit = isEdit;
    }

    /**
     * @param pelamarTesTulis the pelamarTesTulis to set
     */
    public void setPelamarTesTulis(PelamarModel pelamarTesTulis) {
        this.pelamarTesTulis = pelamarTesTulis;
    }

    /**
     * @return the pelamarTesTulis
     */
    public PelamarModel getPelamarTesTulis() {
        return pelamarTesTulis;
    }
}