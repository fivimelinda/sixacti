package propensi.sixacti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LamaranModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    @Size(max=16)
    @Column(name="nik", nullable=false)
    private String nik;


    @Size(max=13)
    @Column(name="noBpjsKetenagakerjaan", nullable=true)
    private String noBpjsKetenagakerjaan;

    @NotNull
    @Size(max=50)
    @Column(name="nama", nullable=false)
    private String nama;

    @NotNull
    @Column(name="timestampPelamar", nullable=false)
    private Date timestampPelamar;

    @NotNull
    @Size(max=50)
    @Column(name="namaIbu", nullable=false)
    private String namaIbu;

    @NotNull
    @Size(max=50)
    @Column(name="alamatDomisili", nullable=false)
    private String alamatDomisili;

    @NotNull
    @Size(max=3)
    @Column(name= "rtDomisili",  nullable = false)
    private Integer rtDomisili;

    @NotNull
    @Size(max=3)
    @Column(name= "rwDomisili",  nullable = false)
    private Integer rwDomisili;

    @NotNull
    @Size(max=50)
    @Column(name="kelurahanDomisili", nullable=false)
    private String kelurahanDomisili;

    @NotNull
    @Size(max=5)
    @Column(name= "kodePosDomisili",  nullable = false)
    private Integer kodePosDomisili;

    @NotNull
    @Size(max=13)
    @Column(name= "telepon",  nullable = false)
    private String telepon;

    @NotNull
    @Size(max=20)
    @Column(name= "pendidikan",  nullable = false)
    private String pendidikan;

    @NotNull
    @Size(max=13)
    @Column(name="noKis", nullable = false)
    private String noKis;

    @NotNull
    @Size(max=255)
    @Column(name="pengalamanKerja", nullable = false)
    private String pengalamanKerja;

    @Size(max=13)
    @Column(name="noBpjsKesehatan", nullable = true)
    private String noBpjsKesehatan;

    @Size(max=13)
    @Column(name= "npwp", nullable = true)
    private String npwp;

    @NotNull
    @Column(name = "fotoKtp", nullable = false)
    @Lob
    private byte[] fotoKtp;

    @NotNull
    @Column(name = "fotoKk", nullable = false)
    @Lob
    private byte[] fotoKk;

    @Column(name = "fotoNpwp", nullable = true)
    @Lob
    private byte[] fotoNpwp;

    @Column(name = "fotoBpjsKes", nullable = true)
    @Lob
    private byte[] fotoBpjsKes;

    @Column(name = "fotoBpjsKet", nullable = true)
    @Lob
    private byte[] fotoBpjsKet;

    @NotNull
    @Column(name = "resume", nullable = false)
    @Lob
    private byte[] resume;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "lowonganId", referencedColumnName = "idLowongan", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private LamaranModel lamaran;

//    public LamaranModel getLamaran() {
//        return lamaran;
//    }
//
//    public void setLamaran(LamaranModel lamaran) {
//        this.lamaran = lamaran;
//    }

    public byte[] getFotoKtp() {
        return fotoKtp;
    }

    public void setFotoKtp(byte[] fotoKtp) {
        this.fotoKtp = fotoKtp;
    }

    public byte[] getFotoKk() {
        return fotoKk;
    }

    public void setFotoKk(byte[] fotoKk) {
        this.fotoKk = fotoKk;
    }

    public byte[] getFotoNpwp() {
        return fotoNpwp;
    }

    public void setFotoNpwp(byte[] fotoNpwp) {
        this.fotoNpwp = fotoNpwp;
    }

    public byte[] getFotoBpjsKes() {
        return fotoBpjsKes;
    }

    public void setFotoBpjsKes(byte[] fotoBpjsKes) {
        this.fotoBpjsKes = fotoBpjsKes;
    }

    public byte[] getFotoBpjsKet() {
        return fotoBpjsKet;
    }

    public void setFotoBpjsKet(byte[] fotoBpjsKet) {
        this.fotoBpjsKet = fotoBpjsKet;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNoBpjsKetenagakerjaan() {
        return noBpjsKetenagakerjaan;
    }

    public void setNoBpjsKetenagakerjaan(String noBpjsKetenagakerjaan) {
        this.noBpjsKetenagakerjaan = noBpjsKetenagakerjaan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTimestampPelamar() {
        return timestampPelamar;
    }

    public void setTimestampPelamar(Date timestampPelamar) {
        this.timestampPelamar = timestampPelamar;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getAlamatDomisili() {
        return alamatDomisili;
    }

    public void setAlamatDomisili(String alamatDomisili) {
        this.alamatDomisili = alamatDomisili;
    }

    public Integer getRtDomisili() {
        return rtDomisili;
    }

    public void setRtDomisili(Integer rtDomisili) {
        this.rtDomisili = rtDomisili;
    }

    public Integer getRwDomisili() {
        return rwDomisili;
    }

    public void setRwDomisili(Integer rwDomisili) {
        this.rwDomisili = rwDomisili;
    }

    public String getKelurahanDomisili() {
        return kelurahanDomisili;
    }

    public void setKelurahanDomisili(String kelurahanDomisili) {
        this.kelurahanDomisili = kelurahanDomisili;
    }

    public Integer getKodePosDomisili() {
        return kodePosDomisili;
    }

    public void setKodePosDomisili(Integer kodePosDomisili) {
        this.kodePosDomisili = kodePosDomisili;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getNoKis() {
        return noKis;
    }

    public void setNoKis(String noKis) {
        this.noKis = noKis;
    }

    public String getPengalamanKerja() {
        return pengalamanKerja;
    }

    public void setPengalamanKerja(String pengalamanKerja) {
        this.pengalamanKerja = pengalamanKerja;
    }

    public String getNoBpjsKesehatan() {
        return noBpjsKesehatan;
    }

    public void setNoBpjsKesehatan(String noBpjsKesehatan) {
        this.noBpjsKesehatan = noBpjsKesehatan;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }
}



