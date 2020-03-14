package propensi.sixacti.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "section")

public class SectionModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSection;

    @NotNull
    @Size(max = 255)
    @Column(name = "namaSection", nullable = false)
    private String namaSection;

    // id departement
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dept", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DepartemenModel departemen;

    /**
     * @return the idSection
     */
    public Long getIdSection() {
        return idSection;
    }

    /**
     * @param idSection the idSection to set
     */
    public void setIdSection(Long idSection) {
        this.idSection = idSection;
    }

    /**
     * @return the namaSection
     */
    public String getNamaSection() {
        return namaSection;
    }

    /**
     * @param namaSection the namaSection to set
     */
    public void setNamaSection(String namaSection) {
        this.namaSection = namaSection;
    }

}