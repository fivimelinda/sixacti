package propensi.sixacti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "lamaran")
public class LamaranModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=16)
    @Column(name="nik", nullable=false)
    private String nik;

    @Size(max=13)
    @Column(name="noBpjsKetenagakerjaan", nullable=true)
    private String noBpjsKetenagakerjaan;

//    @NotNull
//    @Size(max=50)
//    @Column(name="nama", nullable=false)
//    private String nama;

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
    @Column(name= "rtDomisili",  nullable = false)
    private Integer rtDomisili;

    @NotNull
    @Column(name= "rwDomisili",  nullable = false)
    private Integer rwDomisili;

    @NotNull
    @Size(max=50)
    @Column(name="kelurahanDomisili", nullable=false)
    private String kelurahanDomisili;

    @NotNull
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


    @Size(max=13)
    @Column(name="noKis", nullable = true)
    private String noKis;


    @Size(max=255)
    @Column(name="pengalamanKerja", nullable = true)
    private String pengalamanKerja;

    @Column(name="tahunKerja", nullable=true)
    private String tahunKerja;

    @Size(max=255)
    @Column(name="namaPekerjaan", nullable = true)
    private String namaPekerjaan;

    @Size(max=13)
    @Column(name="noBpjsKesehatan", nullable = true)
    private String noBpjsKesehatan;


    @Size(max=13)
    @Column(name= "npwp", nullable = true)
    private String npwp;

    @Column(name = "statusLamaran", nullable = true)
    private String statusLamaran;

//
//    @Column(name = "fotoKtp", nullable=true)
//    @Lob
//    private byte[] fotoKtp;
//
//    @Column(name = "fotoKk", nullable=true)
//    @Lob
//    private byte[] fotoKk;
//
//
//    @Column(name = "fotoNpwp", nullable = true)
//    @Lob
//    private byte[] fotoNpwp;
//
//    @Column(name = "fotoBpjsKes", nullable = true)
//    @Lob
//    private byte[] fotoBpjsKes;
//
//    @Column(name = "fotoBpjsKet", nullable = true)
//    @Lob
//    private byte[] fotoBpjsKet;
//
//
//    @Column(name = "resume", nullable = true)
//    @Lob
//    private byte[] resume;

    /*
    relasi---------------------------------------------------------
    **/



    public PelamarModel getPelamar() {
        return pelamar;
    }

    public void setPelamar(PelamarModel pelamar) {
        this.pelamar = pelamar;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idPelamar", referencedColumnName = "idPelamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PelamarModel pelamar;

//    @OneToMany(mappedBy = "lamaran")
//    @JsonIgnore
//    private List<BerkasModel> listBerkas;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lamaran")
//    @JsonIgnore
    private BerkasModel berkasModel;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lamaran")
//    @JsonIgnore
    private KtpModel ktpModel;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lamaran")
//    @JsonIgnore
    private KkModel kkModel;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lamaran")
//    @JsonIgnore
    private NpwpModel npwpModel;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lamaran")
//    @JsonIgnore
    private BpjsKetenagakerjaanModel bpjsKetenagakerjaan;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lamaran")
//    @JsonIgnore
    private BpjsKesehatanModel bpjsKesehatanModel;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lamaran")
//    @JsonIgnore
    private KisModel kisModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "lowonganId", referencedColumnName = "idLowongan", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private LowonganKerjaModel lowongan;

    public BerkasModel getBerkasModel() {
        return berkasModel;
    }

    public void setBerkasModel(BerkasModel berkasModel) {
        this.berkasModel = berkasModel;
    }

    public LowonganKerjaModel getLowongan() {
        return lowongan;
    }

    public void setLowongan(LowonganKerjaModel lowongan) {
        this.lowongan = lowongan;
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

    public String getTahunKerja() {
        return tahunKerja;
    }

    public void setTahunKerja(String tahunKerja) {
        this.tahunKerja = tahunKerja;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    public KtpModel getKtpModel() {
        return ktpModel;
    }

    public void setKtpModel(KtpModel ktpModel) {
        this.ktpModel = ktpModel;
    }

    public KkModel getKkModel() {
        return kkModel;
    }

    public void setKkModel(KkModel kkModel) {
        this.kkModel = kkModel;
    }

    public NpwpModel getNpwpModel() {
        return npwpModel;
    }

    public void setNpwpModel(NpwpModel npwpModel) {
        this.npwpModel = npwpModel;
    }

    public BpjsKetenagakerjaanModel getBpjsKetenagakerjaan() {
        return bpjsKetenagakerjaan;
    }

    public void setBpjsKetenagakerjaan(BpjsKetenagakerjaanModel bpjsKetenagakerjaan) {
        this.bpjsKetenagakerjaan = bpjsKetenagakerjaan;
    }

    public BpjsKesehatanModel getBpjsKesehatanModel() {
        return bpjsKesehatanModel;
    }

    public void setBpjsKesehatanModel(BpjsKesehatanModel bpjsKesehatanModel) {
        this.bpjsKesehatanModel = bpjsKesehatanModel;
    }

    public KisModel getKisModel() {
        return kisModel;
    }

    public void setKisModel(KisModel kisModel) {
        this.kisModel = kisModel;
    }

    public String getStatusLamaran() {
        return statusLamaran;
    }

    public void setStatusLamaran(String statusLamaran) {
        this.statusLamaran = statusLamaran;
    }
}



