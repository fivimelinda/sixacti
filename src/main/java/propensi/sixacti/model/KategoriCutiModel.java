package propensi.sixacti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "kategori")
public class KategoriCutiModel implements Serializable {
	@Id
	private Integer id;
	
	@NotNull
	@Size(max = 50)
    @Column(name="nama_kategori", nullable = false)
    private String namaKategori;
	
	@Size(max = 100)
    @Column(name="keterangan", nullable = true)
    private String keterangan;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kategori")
    @JsonIgnore
    private List<CutiModel> cuti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaKategori() {
		return namaKategori;
	}

	public void setNamaKategori(String namaKategori) {
		this.namaKategori = namaKategori;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	
	
}
