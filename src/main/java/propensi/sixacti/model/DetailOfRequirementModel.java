package propensi.sixacti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "detail_of_requirement")
public class DetailOfRequirementModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_req_loker", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore

    private RequestLowonganModel idReqLoker;
    @NotNull
    @Size(max = 3)
    @Column(name = "jumlah_laki", nullable = false)
    private Integer jumlahLaki;

    @NotNull
    @Size(max = 3)
    @Column(name = "jumlah_perempuan", nullable = false)
    private Integer jumlahPerempuan;

    @NotNull
    @Size(max = 2)
    @Column(name = "umur", nullable = false)
    private Integer umur;

    @NotNull
    @Size(max = 50)
    @Column(name = "pendidikan", nullable = false)
    private String pendidikan;

    @NotNull
    @Column(name = "job_duty", nullable = false)
    private String jobDuty;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RequestLowonganModel getIdReqLoker() {
        return idReqLoker;
    }

    public void setIdReqLoker(RequestLowonganModel idReqLoker) {
        this.idReqLoker = idReqLoker;
    }

    public Integer getJumlahLaki() {
        return jumlahLaki;
    }

    public void setJumlahLaki(Integer jumlahLaki) {
        this.jumlahLaki = jumlahLaki;
    }

    public Integer getJumlahPerempuan() {
        return jumlahPerempuan;
    }

    public void setJumlahPerempuan(Integer jumlahPerempuan) {
        this.jumlahPerempuan = jumlahPerempuan;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getJobDuty() {
        return jobDuty;
    }

    public void setJobDuty(String jobDuty) {
        this.jobDuty = jobDuty;
    }
}
