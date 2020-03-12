package propensi.sixacti.model;

import javax.persistence.*;
import java.util.List;

public class AsstManagerModel {

    /**
     * Ini PK dari FK ke KaryawanModel
     */
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nik_asst_mngr", referencedColumnName = "nik")
    private KaryawanModel asstManagerUser;


    @OneToMany(mappedBy = "asstManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KaryawanModel> listKaryawan;

    /*
    Section Setter Getter===============================================================================================
     */

    public KaryawanModel getAsstManagerUser() {
        return asstManagerUser;
    }

    public void setAsstManagerUser(KaryawanModel asstManagerUser) {
        this.asstManagerUser = asstManagerUser;
    }

    public List<KaryawanModel> getListKaryawan() {
        return listKaryawan;
    }

    public void setListKaryawan(List<KaryawanModel> listKaryawan) {
        this.listKaryawan = listKaryawan;
    }
}
