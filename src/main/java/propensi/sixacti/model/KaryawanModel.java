package propensi.sixacti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="karyawan")
public class KaryawanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name="jenis_karyawan", nullable = false)
    private boolean jenisKaryawan;

    @NotNull
    @Size(max = 10)
    @Column(name="gaji", nullable = false)
    private Integer gaji;

    @Column(name="id_dept_mngr", insertable=false, updatable=false)
    private Long idDeptManager;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_dept_mngr")
    private Set<KaryawanModel> deptManager;
    
    @Column(name="id_sect_mngr", insertable=false, updatable=false)
    private Long idSectManager;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_sect_mngr")
    private Set<KaryawanModel> sectManager;
    
    @Column(name="id_assist_mngr", insertable=false, updatable=false)
    private Long idAssistManager;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_assist_mngr")
    private Set<KaryawanModel> assistManager;

    @OneToOne(mappedBy = "karyawan")
    private AtributModel atributModel;

    @OneToOne(mappedBy = "karyawan")
    private DetailKontrakModel detailKontrakModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private UserModel user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RoleModel role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dept", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DepartemenModel departemen;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "karyawan")
    private List<CutiModel> cuti;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "karyawan")
    private List<RequestLowonganModel> requestLowongan;

    /*
    Section Setter Getter===============================================================================================
     */

    /**
     *
     * @return id Karyawan
     */
    public Long getId() {
        return id;
    }

    /**
     * Normally this method is prohibited to be used
     * because this method can cause primary key of karyawan scheme to chaneg
     * @param id Karyawan
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * this function is used to get type of the employee
     * @return true if karyawan tetap
     */
    public boolean isJenisKaryawan() {
        return jenisKaryawan;
    }

    /**
     *
     * @param jenisKaryawan
     */
    public void setJenisKaryawan(boolean jenisKaryawan) {
        this.jenisKaryawan = jenisKaryawan;
    }

    /**
     * this funtion to get sallary
     * @return gaji
     */
    public Integer getGaji() {
        return gaji;
    }

    /**
     * this function is to set sallary information
     * @param gaji
     */
    public void setGaji(Integer gaji) {
        this.gaji = gaji;
    }

    /**
     *
     * @return idDeptManager
     */
    public Long getIdDeptManager() {
        return idDeptManager;
    }

    /**
     *
     * @param idDeptManager
     */
    public void setIdDeptManager(Long idDeptManager) {
        this.idDeptManager = idDeptManager;
    }

    /**
     * this function is to get information that list of employess are led by this dept. manager
     * @return deptManager
     */
    public Set<KaryawanModel> getDeptManager() {
        return deptManager;
    }

    public void setDeptManager(Set<KaryawanModel> deptManager) {
        this.deptManager = deptManager;
    }

    /**
     * this function is to get id of sect. manager
     * @return idSectManager
     */
    public Long getIdSectManager() {
        return idSectManager;
    }

    public void setIdSectManager(Long idSectManager) {
        this.idSectManager = idSectManager;
    }

    /**
     * this function is to get information that list of employess are led by this sect. manager
     * @return sectManager
     */
    public Set<KaryawanModel> getSectManager() {
        return sectManager;
    }

    public void setSectManager(Set<KaryawanModel> sectManager) {
        this.sectManager = sectManager;
    }

    public Long getIdAssistManager() {
        return idAssistManager;
    }

    public void setIdAssistManager(Long idAssistManager) {
        this.idAssistManager = idAssistManager;
    }

    /**
     * this function is to get information that list of employess are led by this asst. manager
     * @return asstManager
     */
    public Set<KaryawanModel> getAssistManager() {
        return assistManager;
    }

    public void setAssistManager(Set<KaryawanModel> assistManager) {
        this.assistManager = assistManager;
    }

    public AtributModel getAtributModel() {
        return atributModel;
    }

    public void setAtributModel(AtributModel atributModel) {
        this.atributModel = atributModel;
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

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
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

    // public List<RequestLowonganModel> getRequestLowongan() {
    //     return requestLowongan;
    // }

    // public void setRequestLowongan(List<RequestLowonganModel> requestLowongan) {
    //     this.requestLowongan = requestLowongan;
    // }
}
