package propensi.sixacti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "detail_kontrak")
public class DetailKontrakModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noSurat;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "tanggal_mulai",nullable = false)
    private Date tanggal_mulai;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "tanggal_berakhir",nullable = false)
    private Date tanggal_berakhir;

    @NotNull
    @Size(max = 2)
    @Column(name = "periode",nullable = false)
    private Integer periode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id")
    @JsonIgnore
    private KaryawanModel karyawan;

    // @Size(max = 100)
    // @Column(name = "nama_karyawan", nullable = true)
    // private String namaKaryawan = this.karyawan.getUser().getNama();


    public KaryawanModel getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(KaryawanModel karyawan){
        this.karyawan = karyawan;
    }

    public Integer getPeriode() {
        return periode;
    }

    public Long getNoSurat() {
        return noSurat;
    }

    public void setNoSurat(Long noSurat) {
        this.noSurat = noSurat;
    }

    public Date getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(Date tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public Date getTanggal_berakhir() {
        return tanggal_berakhir;
    }

    public void setTanggal_berakhir(Date tanggal_berakhir) {
        this.tanggal_berakhir = tanggal_berakhir;
    }

    public void setPeriode(Integer periode) {
        this.periode = periode;
    }

}
