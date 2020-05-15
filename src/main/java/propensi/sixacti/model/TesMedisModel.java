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
    @Column(name = "tinggiBadan", nullable = false)
    private Integer tinggiBadan;

    @NotNull
    @Column(name = "beratBadan", nullable = false)
    private Integer beratBadan;

    @NotNull
    @Column(name = "tdBatasAtas", nullable = false)
    private Integer tdBatasAtas;

    @NotNull
    @Column(name = "tdBatasBawah", nullable = false)
    private Integer tdBatasBawah;
  
    @NotNull
    @Size(max = 255)
    @Column(name = "butaWarna", nullable = false)
    private String butaWarna;

    @NotNull
    @Size(max = 255)
    @Column(name = "riwayatPenyakit", nullable = false)
    private String riwayatPenyakit;

    @NotNull
    @Column(name="isEdit", nullable=false)
    private Boolean isEdit;

    @NotNull
    @Column(name="isLolos", nullable=false)
    private Boolean isLolos;

    @NotNull
    @Column(name="isGagal", nullable=false)
    private Boolean isGagal;
    
    //reference ke pelamar
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPelamar", referencedColumnName = "idPelamar")
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
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
    public Integer getTinggiBadan() {
        return tinggiBadan;
    }

    /**
     * @param tinggiBadan the tinggiBadan to set
     */
    public void setTinggiBadan(Integer tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    /**
     * @return the beratBadan
     */
    public Integer getBeratBadan() {
        return beratBadan;
    }

    /**
     * @param beratBadan the beratBadan to set
     */
    public void setBeratBadan(Integer beratBadan) {
        this.beratBadan = beratBadan;
    }

    /**
     * @return the butaWarna
     */
    public String getButaWarna() {
        return butaWarna;
    }
    
    /**
     * @param butaWarna the butaWarna to set
     */
    public void setButaWarna(String butaWarna) {
        this.butaWarna = butaWarna;
    }

    /**
     * @return the tdBatasAtas
     */
    public Integer getTdBatasAtas() {
        return tdBatasAtas;
    }

    /**
     * @param tdBatasAtas the tdBatasAtas to set
     */
    public void setTdBatasAtas(Integer tdBatasAtas) {
        this.tdBatasAtas = tdBatasAtas;
    }

    /**
     * @return the tdBatasBawah
     */
    public Integer getTdBatasBawah() {
        return tdBatasBawah;
    }
    /**
     * @param tdBatasBawah the tdBatasBawah to set
     */
    public void setTdBatasBawah(Integer tdBatasBawah) {
        this.tdBatasBawah = tdBatasBawah;
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

    /**
     * @param isGagal the isGagal to set
     */
    public void setIsGagal(Boolean isGagal) {
        this.isGagal = isGagal;
    }

    /**
     * @return the isGagal
     */
    public Boolean getIsGagal() {
        return isGagal;
    }
}