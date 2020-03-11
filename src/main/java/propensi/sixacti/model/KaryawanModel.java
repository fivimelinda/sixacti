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
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private RoleModel role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dept", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DepartemenModel departement;

    @NotNull
    @Column(name="jenis_karyawan", nullable = false)
    private boolean jenisKaryawan;

    @NotNull
    @Size(max = 10)
    @Column(name="gaji", nullable = false)
    private Integer gaji;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_dept_mngr", referencedColumnName = "nik", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private KaryawanModel deptManager;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_sect_mngr", referencedColumnName = "nik", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private KaryawanModel sectManager;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_asst_mngr", referencedColumnName = "nik", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private KaryawanModel asstManager;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public DepartemenModel getDepartement() {
        return departement;
    }

    public void setDepartement(DepartemenModel departement) {
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
}
