package propensi.sixacti.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lowongan")
public class LowonganKerjaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLowongan;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggalMulai", nullable = false)
    private Date tanggalMulai;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggalBerakhir", nullable = false)
    private Date tanggalBerakhir;

    @NotNull
    @Size(max = 255)
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @NotNull
    @Column(name = "nomorLowongan", nullable = false)
    private Integer nomorLowongan;

    @OneToMany(mappedBy = "lowongan", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private List<LamaranModel> listLamaran;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="requestLowonganId", referencedColumnName = "id")
    private RequestLowonganModel requestLowongan; 

    public List<LamaranModel> getListLamaran() {
        return listLamaran;
    }

    public void setListLamaran(List<LamaranModel> listLamaran) {
        this.listLamaran = listLamaran;
    }

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

