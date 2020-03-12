package propensi.sixacti.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table (name = "departement")
public class DepartementModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size (max = 50)
    @Column (name = "nama_departement")
    private String namaDepartement;

    /*
    Section Setter Getter===============================================================================================
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaDepartement() {
        return namaDepartement;
    }

    public void setNamaDepartement(String namaDepartement) {
        this.namaDepartement = namaDepartement;
    }
}
