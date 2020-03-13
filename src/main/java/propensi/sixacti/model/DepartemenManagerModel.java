//package propensi.sixacti.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "departement_manager")
//public class DepartemenManagerModel {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "nikDeptMngr", referencedColumnName = "nik")
//    private KaryawanModel deptManagerUser;
//
//
//    @OneToMany(mappedBy = "deptManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<KaryawanModel> listKaryawan;
//
//    /*
//    Section Setter Getter===============================================================================================
//     */
//
//    public KaryawanModel getDeptManagerUser() {
//        return deptManagerUser;
//    }
//
//    public void setDeptManagerUser(KaryawanModel deptManagerUser) {
//        this.deptManagerUser = deptManagerUser;
//    }
//
//    public List<KaryawanModel> getListKaryawan() {
//        return listKaryawan;
//    }
//
//    public void setListKaryawan(List<KaryawanModel> listKaryawan) {
//        this.listKaryawan = listKaryawan;
//    }
//}
