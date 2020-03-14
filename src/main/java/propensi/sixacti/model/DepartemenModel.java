package propensi.sixacti.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "departemen")
public class DepartemenModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size (max = 50)
    @Column (name = "nama_departemen")
    private String namaDepartemen;
    
    @OneToMany(mappedBy = "departemen", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private List<KaryawanModel> listKaryawan;

    @OneToMany(mappedBy = "departemen", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private List<SectionModel> listSection;
    /*
    Section Setter Getter===============================================================================================
     */

    public Long getId() {
        return id;
    }

	public void setId(Long id) {
        this.id = id;
    }

    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    public void setNamaDepartemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
    }
    
    public List<KaryawanModel> getListKaryawan() {
		return listKaryawan;
	}

	public void setListKaryawan(List<KaryawanModel> listKaryawan) {
		this.listKaryawan = listKaryawan;
	}
}
