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
    @Column(name = "judulLoker")
    private String judulLoker;

    @NotNull
    @Column(name = "departement")
    private String departement;

    @NotNull
    @Column(name = "section")
    private String section;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggalMulai", nullable = false)
    private Date tanggalMulai;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggalBerakhir", nullable = false)
    private Date tanggalBerakhir;

    @NotNull
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @NotNull
    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "lowongan", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private List<LamaranModel> listLamaran;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="requestLowonganId", referencedColumnName = "id")
    private RequestLowonganModel requestLowongan; 



    public Long getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(Long idLowongan) {
        this.idLowongan = idLowongan;
    }

    public String getJudulLoker() {
        return judulLoker;
    }

    public void setJudulLoker(String judulLoker) {
        this.judulLoker = judulLoker;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public RequestLowonganModel getRequestLowongan() {
        return requestLowongan;
    }

    public void setRequestLowongan(RequestLowonganModel requestLowongan) {
        this.requestLowongan = requestLowongan;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<LamaranModel> getListLamaran() {
        return listLamaran;
    }

    public void setListLamaran(List<LamaranModel> listLamaran) {
        this.listLamaran = listLamaran;
    }
}

