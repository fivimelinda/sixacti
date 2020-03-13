package propensi.sixacti.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "role")
public class RoleModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column (name = "nama_role")
    private String namaRole;
    
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private List<KaryawanModel> listKaryawan; 

    /*
    Section Setter Getter===============================================================================================
     */

    public List<KaryawanModel> getListKaryawan() {
		return listKaryawan;
	}

	public void setListKaryawan(List<KaryawanModel> listKaryawan) {
		this.listKaryawan = listKaryawan;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }
}
