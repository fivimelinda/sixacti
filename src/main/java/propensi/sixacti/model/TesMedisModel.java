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
@Table(name = "tesMedis")

public class TesMedisModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTesMedis;

    @NotNull
    @Size(max = 255)
    @Column(name = "tinggiBadan", nullable = false)
    private String tinggiBadan;

    @NotNull
    @Size(max = 255)
    @Column(name = "beratBadan", nullable = false)
    private String beratBadan;

    @NotNull
    @Size(max = 255)
    @Column(name = "tekananDarah", nullable = false)
    private String tekananDarah;
  
    @NotNull
    @Column(name = "butaWarna", nullable = false)
    private Boolean butaWarna;

    @NotNull
    @Size(max = 255)
    @Column(name = "riwayatPenyakit", nullable = false)
    private String riwayatPenyakit;

    @NotNull
    @Column(name="isEdit", nullable=false)
    private Boolean isEdit;
    
    
    //reference ke pelamar
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPelamar", referencedColumnName = "idPelamar")
    @OnDelete(action= OnDeleteAction.CASCADE)
    //@JsonIgnore
    private PelamarModel pelamarTesMedis;


    /**
     * @return the idTesMedis
     */
    public Long getIdTesMedis() {
        return idTesMedis;
    }

    /**
     * @param idTesMedis the idTesMedis to set
     */
    public void setIdTesMedis(Long idTesMedis) {
        this.idTesMedis = idTesMedis;
    }

    /**
     * @return the tinggiBadan
     */
    public String getTinggiBadan() {
        return tinggiBadan;
    }

    /**
     * @param tinggiBadan the tinggiBadan to set
     */
    public void setTinggiBadan(String tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    /**
     * @return the beratBadan
     */
    public String getBeratBadan() {
        return beratBadan;
    }

    /**
     * @param beratBadan the beratBadan to set
     */
    public void setBeratBadan(String beratBadan) {
        this.beratBadan = beratBadan;
    }

    /**
     * @return the butaWarna
     */
    public Boolean getButaWarna() {
        return butaWarna;
    }
    
    /**
     * @param butaWarna the butaWarna to set
     */
    public void setButaWarna(Boolean butaWarna) {
        this.butaWarna = butaWarna;
    }

    /**
     * @return the tekananDarah
     */
    public String getTekananDarah() {
        return tekananDarah;
    }

    /**
     * @param tekananDarah the tekananDarah to set
     */
    public void setTekananDarah(String tekananDarah) {
        this.tekananDarah = tekananDarah;
    }

    /**
     * @return the riwayatPenyakit
     */
    public String getRiwayatPenyakit() {
        return riwayatPenyakit;
    }

    /**
     * @param riwayatPenyakit the riwayatPenyakit to set
     */
    public void setRiwayatPenyakit(String riwayatPenyakit) {
        this.riwayatPenyakit = riwayatPenyakit;
    }

    /**
     * @return the pelamarTesMedis
     */
    public PelamarModel getPelamarTesMedis() {
        return pelamarTesMedis;
    }

    /**
     * @param pelamarTesMedis the pelamarTesMedis to set
     */
    public void setPelamarTesMedis(PelamarModel pelamarTesMedis) {
        this.pelamarTesMedis = pelamarTesMedis;
    }

    /**
     * @return the isEdit
     */
    public Boolean getIsEdit() {
        return isEdit;
    }
    
    /**
     * @param isEdit the isEdit to set
     */
    public void setIsEdit(Boolean isEdit) {
        this.isEdit = isEdit;
    }

}