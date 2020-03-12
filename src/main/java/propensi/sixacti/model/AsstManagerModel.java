package propensi.sixacti.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "asst_manager")
public class AsstManagerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nikAsstMngr", referencedColumnName = "id")
    private KaryawanModel asstManagerUser;

    @OneToMany(mappedBy = "asstManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KaryawanModel> listKaryawan;

    /*
    Section Setter Getter===============================================================================================
     */


}
