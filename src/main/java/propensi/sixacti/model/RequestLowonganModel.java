package propensi.sixacti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="request_lowongan")
public class RequestLowonganModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @NotNull
    @Size(max = 50)
    @Column(name = "departement", nullable = false)
    private String departement;

    @NotNull
    @Size(max = 50)
    @Column(name = "section", nullable = false)
    private String section;

    @NotNull
    @Size(max = 50)
    @Column(name = "supervisor", nullable = false)
    private String supervisor;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date_wanted", nullable = false)
    private Date dateWanted;

    @NotNull
    @Column(name="shift", nullable = false)
    private boolean shift;

    @NotNull
    @Min(1)
    @Column(name="jumlah", nullable = false)
    private Integer jumlah;

    @NotNull
    @Size(max = 10)
    @Column(name = "gaji", nullable = false)
    private String gaji;

//    @NotNull
//    @Column(name = "nama_replacement", nullable = false)
//    private List<String> namaReplacement;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idKaryawan", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KaryawanModel karyawan;

    @OneToMany(mappedBy = "idReqLoker", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<DetailOfRequirementModel> detailOfRequirement;
    
    @OneToOne(mappedBy = "requestLowongan")
    private LowonganKerjaModel lowonganKerja; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Date getDateWanted() {
        return dateWanted;
    }

    public void setDateWanted(Date dateWanted) {
        this.dateWanted = dateWanted;
    }

    public boolean isShift() {
        return shift;
    }

    public void setShift(boolean shift) {
        this.shift = shift;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DetailOfRequirementModel> getDetailOfRequirement() {
        return detailOfRequirement;
    }

    public void setDetailOfRequirement(List<DetailOfRequirementModel> detailOfRequirement) {
        this.detailOfRequirement = detailOfRequirement;
    }

//    public List<String> getNamaReplacement() {
//        return namaReplacement;
//    }
//
//    public void setNamaReplacement(List<String> namaReplacement) {
//        this.namaReplacement = namaReplacement;
//    }
}