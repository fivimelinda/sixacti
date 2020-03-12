package propensi.sixacti.model;

import javax.persistence.*;
import java.util.List;

public class SectionManagerModel {

    /**
     * Ini PK dari FK ke KaryawanModel
     */
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nik_sect_mngr", referencedColumnName = "nik")
    private KaryawanModel sectManagerUser;


    @OneToMany(mappedBy = "sectManager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KaryawanModel> listKaryawan;

    /*
    Section Setter Getter===============================================================================================
     */

    public KaryawanModel getSectManagerUser() {
        return sectManagerUser;
    }

    public void setSectManagerUser(KaryawanModel sectManagerUser) {
        this.sectManagerUser = sectManagerUser;
    }

    public List<KaryawanModel> getListKaryawan() {
        return listKaryawan;
    }

    public void setListKaryawan(List<KaryawanModel> listKaryawan) {
        this.listKaryawan = listKaryawan;
    }
}