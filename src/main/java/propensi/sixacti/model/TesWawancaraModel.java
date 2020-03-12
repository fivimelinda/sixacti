package propensi.sixacti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    
}