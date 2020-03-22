package propensi.sixacti.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cuti")
public class CutiModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private KaryawanModel karyawan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kategori", referencedColumnName = "id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KategoriCutiModel kategori;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="tanggal_mulai", nullable = false)
    private Date tanggalMulai;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="tanggal_sampai", nullable = false)
    private Date tanggalSampai;

    @NotNull
    @Column(name="status", nullable = false)
    private String status;

    @NotNull
    @Column(name="carry", nullable = false)
    private Integer carry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KaryawanModel getKaryawan() {
		return karyawan;
	}

	public void setKaryawan(KaryawanModel karyawan) {
		this.karyawan = karyawan;
	}

	public KategoriCutiModel getKategoriModel() {
		return kategori;
	}

	public void setKategori(KategoriCutiModel kategori) {
		this.kategori = kategori;
	}

	public Date getTanggalMulai() {
		return tanggalMulai;
	}

	public void setTanggalMulai(Date tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}

	public Date getTanggalSampai() {
		return tanggalSampai;
	}

	public void setTanggalSampai(Date tanggalSampai) {
		this.tanggalSampai = tanggalSampai;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCarry() {
		return carry;
	}

	public void setCarry(Integer carry) {
		this.carry = carry;
	}
    
    
}