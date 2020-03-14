package propensi.sixacti.model;


import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "atribut")
public class AtributModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_atribut;

    @NotNull
    @Size(max = 5)
    @Column(name = "ukuran_jas_lab", nullable = false)
    private String ukuran_jas_lab;

    @NotNull
    @Size(max = 5)
    @Column(name = "ukuran_helm", nullable = false)
    private String ukuran_helm;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id")
    private KaryawanModel karyawan;


    public boolean isStatus() {
        return status;
    }

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

    public void setStatus(boolean status) {
        this.status = status;
    }

}

