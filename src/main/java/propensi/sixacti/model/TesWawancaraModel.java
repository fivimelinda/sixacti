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

    // reference ke pelamar
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPelamar", referencedColumnName = "idPelamar")
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private PelamarModel pelamarTesWawancara;

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
}