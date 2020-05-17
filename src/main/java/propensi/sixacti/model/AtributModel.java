package propensi.sixacti.model;


import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "atribut")
public class AtributModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_atribut;

    @NotNull
    @Size(max = 10)
    @Column(name = "ukuran_sepatu", nullable = false)
    private String ukuran_sepatu;

    @NotNull
    @Size(max = 20)
    @Column(name = "ukuran_baju", nullable = false)
    private String ukuran_baju;

    @NotNull
    @Size(max = 20)
    @Column(name = "ukuran_jas_lab", nullable = false)
    private String ukuran_jas_lab;

    @NotNull
    @Size(max = 20)
    @Column(name = "ukuran_helm", nullable = false)
    private String ukuran_helm;

    @NotNull
    @Column(name = "status", nullable = false)
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private KaryawanModel karyawan;

    public KaryawanModel getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(KaryawanModel karyawan) {
        this.karyawan = karyawan;
    }
    
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPelamar", referencedColumnName = "idPelamar")
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private PelamarModel pelamarAtribut;

    /**
     * @param pelamarAtribut the pelamarAtribut to set
     */
    public void setPelamarAtribut(PelamarModel pelamarAtribut) {
        this.pelamarAtribut = pelamarAtribut;
    }

    /**
     * @return the pelamarAtribut
     */
    public PelamarModel getPelamarAtribut() {
        return pelamarAtribut;
    }

    /**
     * @return the ukuran_baju
     */
    public String getUkuran_baju() {
        return ukuran_baju;
    }

    /**
     * @param ukuran_baju the ukuran_baju to set
     */
    public void setUkuran_baju(String ukuran_baju) {
        this.ukuran_baju = ukuran_baju;
    }

    /**
     * @return the ukuran_sepatu
     */
    public String getUkuran_sepatu() {
        return ukuran_sepatu;
    }

    /**
     * @param ukuran_sepatu the ukuran_sepatu to set
     */
    public void setUkuran_sepatu(String ukuran_sepatu) {
        this.ukuran_sepatu = ukuran_sepatu;
    }

//    /**
//     * @return the karyawan
//     */
//    public KaryawanModel getKaryawan() {
//        return karyawan;
//    }
//
//    /**
//     * @param karyawan the karyawan to set
//     */
//    public void setKaryawan(KaryawanModel karyawan) {
//        this.karyawan = karyawan;
//
//    }

    public Long getId_atribut() {
        return id_atribut;
    }

    public void setId_atribut(Long id_atribut) {
        this.id_atribut = id_atribut;
    }

    public String getUkuran_jas_lab() {
        return ukuran_jas_lab;
    }

    public void setUkuran_jas_lab(String ukuran_jas_lab) {
        this.ukuran_jas_lab = ukuran_jas_lab;
    }

    public String getUkuran_helm() {
        return ukuran_helm;
    }

    public void setUkuran_helm(String ukuran_helm) {
        this.ukuran_helm = ukuran_helm;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

}

