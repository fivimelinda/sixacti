package propensi.sixacti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LowonganKerjaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long idLowongan;

    @NotNull
    @Column(name = "tanggalMulai", nullable = false)
    private Date tanggalMulai;

    @NotNull
    @Column(name = "tanggalBerakhir", nullable = false)
    private Date tanggalBerakhir;

    @NotNull
    @Size(max = 255)
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @NotNull
    @Size(max =50)
    @Column(name = "nomorLowongan", nullable = false)
    private Integer nomorLowongan;

//    @OneToMany(mappedBy = "lowongan", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
//    private List<LamaranModel> listLamaran;
//
//    public List<LamaranModel> getListLamaran() {
//        return listLamaran;
//    }
//
//    public void setListLamaran(List<LamaranModel> listLamaran) {
//        this.listLamaran = listLamaran;
//    }

    public Long getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(Long idLowongan) {
        this.idLowongan = idLowongan;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalBerakhir() {
        return tanggalBerakhir;
    }

    public void setTanggalBerakhir(Date tanggalBerakhir) {
        this.tanggalBerakhir = tanggalBerakhir;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getNomorLowongan() {
        return nomorLowongan;
    }

    public void setNomorLowongan(Integer nomorLowongan) {
        this.nomorLowongan = nomorLowongan;
    }
}

