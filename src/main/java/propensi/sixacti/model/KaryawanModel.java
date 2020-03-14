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



//    
//    @OneToOne(mappedBy = "detailKontrak", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private DetailKontrakModel detailKontrak;

    /*
    Section Setter Getter===============================================================================================
     */

}
