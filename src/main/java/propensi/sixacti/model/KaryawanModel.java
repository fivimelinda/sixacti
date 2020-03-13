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
    
    @NotNull
    @Column(name="jenis_karyawan", nullable = false)
    private boolean jenisKaryawan;

    @NotNull
    @Size(max = 10)
    @Column(name="gaji", nullable = false)
    private Integer gaji;

    @Column(name="id_dept_mngr", insertable=false, updatable=false)
    private Long idManager;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_dept_mngr")
    private Set<KaryawanModel> translations;
    
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "idDeptMngr", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private DepartemenManagerModel deptManager;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "idSectMngr", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private SectionManagerModel sectManager;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "idAsstMngr", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private AsstManagerModel asstManager;

//    @OneToOne(mappedBy = "deptManagerUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private DepartemenManagerModel idDeptManager;
//
//    @OneToOne(mappedBy = "sectManagerUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private SectionManagerModel idsectManager;
//
//    @OneToOne(mappedBy = "asstManagerUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private AsstManagerModel idAsstManager;
    
//    @OneToOne(mappedBy = "atributModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private AtributModel atributModel;
//    
//    @OneToOne(mappedBy = "detailKontrak", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private DetailKontrakModel detailKontrak;




    /*
    Section Setter Getter===============================================================================================
     */

}
