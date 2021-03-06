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
@Table(name = "tesWawancara")

public class TesWawancaraModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTesWawancara;

    @NotNull
    @Size(max = 255)
    @Column(name = "nilai", nullable = false)
    private String nilai;

    @NotNull
    @Size(max = 255)
    @Column(name = "feedback", nullable = false)
    private String feedback;

    @NotNull
    @Column(name = "isEdit", nullable = false)
    private Boolean isEdit;

    @NotNull
    @Column(name = "isLolos", nullable = false)
    private Boolean isLolos;

    @NotNull
    @Column(name="isGagal", nullable=false)
    private Boolean isGagal;

    // reference ke pelamar
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPelamar", referencedColumnName = "idPelamar")
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private PelamarModel pelamarTesWawancara;

    /**
     * @return the isGagal
     */
    public Boolean getIsGagal() {
        return isGagal;
    }

    /**
     * @param isGagal the isGagal to set
     */
    public void setIsGagal(Boolean isGagal) {
        this.isGagal = isGagal;
    }
    
    /**
     * @return the idTesWawancara
     */
    public Long getIdTesWawancara() {
        return idTesWawancara;
    }

    /**
     * @param idTesWawancara the idTesWawancara to set
     */
    public void setIdTesWawancara(Long idTesWawancara) {
        this.idTesWawancara = idTesWawancara;
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

    /**
     * @return the feedback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Boolean getIsEdit(){
        return isEdit;
    }

    public void setIsEdit(Boolean isEdit){
        this.isEdit = isEdit;
    }

    /**
     * @return the pelamarTesWawancara
     */
    public PelamarModel getPelamarTesWawancara() {
        return pelamarTesWawancara;
    }

    /**
     * @param pelamarTesWawancara the pelamarTesWawancara to set
     */
    public void setPelamarTesWawancara(PelamarModel pelamarTesWawancara) {
        this.pelamarTesWawancara = pelamarTesWawancara;
    }

    /**
     * @return the isLolos
     */
    public Boolean getIsLolos() {
        return isLolos;
    }

    /**
     * @param isLolos the isLolos to set
     */
    public void setIsLolos(Boolean isLolos) {
        this.isLolos = isLolos;
    }
}