package propensi.sixacti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="karyawan")
public class KaryawanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @NotNull
//    @Column(name="jenis_karyawan", nullable = false)
//    @JsonIgnore
//    private boolean jenisKaryawan;

    @NotNull
    @Column(name="gaji", nullable = false)
    @Min(1)
    private Integer gaji;
    
    @Column(name="sisa", nullable = false)
    private Integer sisaCuti;
    



    @OneToOne(mappedBy = "karyawan", optional = true)
    @JsonIgnore
    private AtributModel atributModel;

    /**
     * @return the atributModel
     */
    public AtributModel getAtributModel() {
        return atributModel;
    }

    /**
     * @param atributModel the atributModel to set
     */
    public void setAtributModel(AtributModel atributModel) {
        this.atributModel = atributModel;
    }

    @OneToOne(mappedBy = "karyawan", cascade = CascadeType.ALL,  fetch = FetchType.LAZY,optional = true)
    @JsonIgnore
    private DetailKontrakModel detailKontrakModel;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private UserModel user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dept", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DepartemenModel departemen;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sect", referencedColumnName = "idSection", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SectionModel section;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "karyawan")
    @JsonIgnore
    private List<CutiModel> cuti;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // private RoleModel role;

    //    @NotNull
//    @Column(name="hutangCuti", nullable = false)
//    private Integer hutangCuti;

//    @Column(name="id_dept_mngr", insertable=false, updatable=false)
//    private Long idDeptManager;
//    
//    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
//    @JoinColumn(name="id_dept_mngr")
//    private Set<KaryawanModel> deptManager;
//    
//    @Column(name="id_sect_mngr", insertable=false, updatable=false)
//    private Long idSectManager;
//    
//    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
//    @JoinColumn(name="id_sect_mngr")
//    private Set<KaryawanModel> sectManager;
//    
//    @Column(name="id_assist_mngr", insertable=false, updatable=false)
//    private Long idAssistManager;
//    
//    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
//    @JoinColumn(name="id_assist_mngr")
//    private Set<KaryawanModel> assistManager;

// <<<<<<< HEAD
//     @OneToMany(cascade = CascadeType.ALL, mappedBy = "karyawan")
//     @JsonIgnore
//     private List<RequestLowonganModel> requestLowongan;
// =======
//     // @OneToMany(cascade = CascadeType.ALL, mappedBy = "karyawan")
//     // @JsonIgnore
//     // private List<RequestLowonganModel> requestLowongan;
    
// >>>>>>> master

    /*
    Section Setter Getter===============================================================================================
     */
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public boolean isJenisKaryawan() {
//		return jenisKaryawan;
//	}

	// public void setJenisKaryawan(boolean jenisKaryawan) {
	// 	this.jenisKaryawan = jenisKaryawan;
	// }

	public Integer getGaji() {
		return gaji;
	}

	public void setGaji(Integer gaji) {
		this.gaji = gaji;
	}

	public Integer getSisaCuti() {
		return sisaCuti;
	}

	public void setSisaCuti(Integer sisaCuti) {
		this.sisaCuti = sisaCuti;
	}



    public DetailKontrakModel getDetailKontrakModel() {
        return detailKontrakModel;
    }

    public void setDetailKontrakModel(DetailKontrakModel detailKontrakModel) {
        this.detailKontrakModel = detailKontrakModel;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    

    public DepartemenModel getDepartemen() {
        return departemen;
    }

    public void setDepartemen(DepartemenModel departemen) {
        this.departemen = departemen;
    }

    public List<CutiModel> getCuti() {
        return cuti;
    }

    public void setCuti(List<CutiModel> cuti) {
        this.cuti = cuti;
    }

	public SectionModel getSection() {
		return section;
	}

	public void setSection(SectionModel section) {
		this.section = section;
    }

    //	public Long getIdDeptManager() {
//		return idDeptManager;
//	}
//
//	public void setIdDeptManager(Long idDeptManager) {
//		this.idDeptManager = idDeptManager;
//	}
//    
//    public Set<KaryawanModel> getDeptManager() {
//        return deptManager;
//    }
//
//    public void setDeptManager(Set<KaryawanModel> deptManager) {
//        this.deptManager = deptManager;
//    }

    /**
     * this function is to get id of sect. manager
     * @return idSectManager
     */
//    public Long getIdSectManager() {
//        return idSectManager;
//    }
//
//    public void setIdSectManager(Long idSectManager) {
//        this.idSectManager = idSectManager;
//    }
//
//    /**
//     * this function is to get information that list of employess are led by this sect. manager
//     * @return sectManager
//     */
//    public Set<KaryawanModel> getSectManager() {
//        return sectManager;
//    }
//
//    public void setSectManager(Set<KaryawanModel> sectManager) {
//        this.sectManager = sectManager;
//    }
//
//    public Long getIdAssistManager() {
//        return idAssistManager;
//    }
//
//    public void setIdAssistManager(Long idAssistManager) {
//        this.idAssistManager = idAssistManager;
//    }

    /**
     * this function is to get information that list of employess are led by this asst. manager
     * @return asstManager
     */
//    public Set<KaryawanModel> getAssistManager() {
//        return assistManager;
//    }
//
//    public void setAssistManager(Set<KaryawanModel> assistManager) {
//        this.assistManager = assistManager;
//    }
//
//    public AtributModel getAtributModel() {
//        return atributModel;
//    }
//
//    public void setAtributModel(AtributModel atributModel) {
//        this.atributModel = atributModel;
//    }
    
    // public RoleModel getRole() {
    //     return role;
    // }

    // public void setRole(RoleModel role) {
    //     this.role = role;
    // }

	// public List<RequestLowonganModel> getRequestLowongan() {
	// 	return requestLowongan;
	// }

// <<<<<<< HEAD
// 	public void setRequestLowongan(List<RequestLowonganModel> requestLowongan) {
// 		this.requestLowongan = requestLowongan;
//     }
    
// =======
// 	// public void setRequestLowongan(List<RequestLowonganModel> requestLowongan) {
// 	// 	this.requestLowongan = requestLowongan;
// 	// }
// >>>>>>> master
}
