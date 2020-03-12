package propensi.sixacti.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="karyawan")
public class KaryawanModel {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nik", referencedColumnName = "NIK")
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
    private DepartementModel departement;

    @NotNull
    @Column(name="jenis_karyawan", nullable = false)
    private boolean jenisKaryawan;

    @NotNull
    @Size(max = 10)
    @Column(name="gaji", nullable = false)
    private Integer gaji;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dept_mngr", referencedColumnName = "nik_dept_mngr", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DepartemenManagerModel deptManager;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sect_mngr", referencedColumnName = "nik_sect_mngr", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private SectionManagerModel sectManager;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_asst_mngr", referencedColumnName = "nik_asst_mngr", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AsstManagerModel asstManager;

    @OneToOne(mappedBy = "deptManagerUser")
    private DepartemenManagerModel idDeptManager;

    @OneToOne(mappedBy = "secttManagerUser")
    private DepartemenManagerModel idsectManager;

    @OneToOne(mappedBy = "asstManagerUser")
    private DepartemenManagerModel idAssttManager;

    /*
    Section Setter Getter===============================================================================================
     */

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

    public DepartementModel getDepartement() {
        return departement;
    }

    public void setDepartement(DepartementModel departement) {
        this.departement = departement;
    }

    public boolean isJenisKaryawan() {
        return jenisKaryawan;
    }

    public void setJenisKaryawan(boolean jenisKaryawan) {
        this.jenisKaryawan = jenisKaryawan;
    }

    public Integer getGaji() {
        return gaji;
    }

    public void setGaji(Integer gaji) {
        this.gaji = gaji;
    }

    public DepartemenManagerModel getDeptManager() {
        return deptManager;
    }

    public void setDeptManager(DepartemenManagerModel deptManager) {
        this.deptManager = deptManager;
    }

    public SectionManagerModel getSectManager() {
        return sectManager;
    }

    public void setSectManager(SectionManagerModel sectManager) {
        this.sectManager = sectManager;
    }

    public AsstManagerModel getAsstManager() {
        return asstManager;
    }

    public void setAsstManager(AsstManagerModel asstManager) {
        this.asstManager = asstManager;
    }

    public DepartemenManagerModel getIdDeptManager() {
        return idDeptManager;
    }

    public void setIdDeptManager(DepartemenManagerModel idDeptManager) {
        this.idDeptManager = idDeptManager;
    }

    public DepartemenManagerModel getIdsectManager() {
        return idsectManager;
    }

    public void setIdsectManager(DepartemenManagerModel idsectManager) {
        this.idsectManager = idsectManager;
    }

    public DepartemenManagerModel getIdAssttManager() {
        return idAssttManager;
    }

    public void setIdAssttManager(DepartemenManagerModel idAssttManager) {
        this.idAssttManager = idAssttManager;
    }
}
