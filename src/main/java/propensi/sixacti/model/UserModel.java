package propensi.sixacti.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profile")
public class UserModel implements Serializable {

    @Id
    @Size(max = 16)
    @Column(name = "nik", nullable = false)
    private String nik;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "tanggal_lahir" ,nullable = false)
    private Date tanggal_lahir;
    
    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private Boolean jenis_kelamin;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "tempat_lahir", nullable = false)
    private String tempat_lahir;

    @NotNull
    @Size(max = 50)
    @Column(name = "alamat", nullable = false)
    private String alamat;

    @NotNull
    @Size(max = 3)
    @Column(name = "RT", nullable = false)
    private Integer RT;

    @NotNull
    @Size(max = 3)
    @Column(name = "RW", nullable = false)
    private Integer RW;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "kelurahan", nullable = false)
    private String kelurahan;

    @NotNull
    @Size(max = 50)
    @Column(name = "kecamatan", nullable = false)
    private String kecamatan;

    @NotNull
    @Size(max = 5)
    @Column(name = "kode_pos", nullable = false)
    private Integer kodePos;
   
    @NotNull
    @Size(max = 15)
    @Column(name = "telepon", nullable = false)
    private String telepon;

    @NotNull
    @Size(max = 50)
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Size(max = 15)
    @Column(name = "NPWP", nullable = false)
    private String NPWP;


    /*
    Relation
    **/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_akun", referencedColumnName = "idAkun")
    @JsonIgnore
    private AkunModel akun;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "idUsers", referencedColumnName = "id")
    @JsonIgnore
    private Users users;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private KaryawanModel karyawan;

    @OneToOne(mappedBy = "userPelamar")
    @JsonIgnore
    private PelamarModel pelamar;

    /*
    setter getter
    **/
       
    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    public String getNPWP() {
        return NPWP;
    }

    public String getNIK() {
        return nik;
    }

    public void setNIK(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public boolean isJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(boolean jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getRT() {
        return RT;
    }

    public void setRT(Integer rT) {
        this.RT = rT;
    }

    public Integer getRW() {
        return RW;
    }

    public void setRW(Integer rW) {
        this.RW = rW;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public Integer getKode_pos() {
        return kodePos;
    }

    public void setKodePos(Integer kodePos) {
        this.kodePos = kodePos;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNPWP(String nPWP) {
        this.NPWP = nPWP;
    }

//    public KaryawanModel getKaryawan() {
//        return karyawan;
//    }
//
//    public void setKaryawan(KaryawanModel karyawan) {
//        this.karyawan = karyawan;
//    }

}


    