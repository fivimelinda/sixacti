package propensi.sixacti.rest;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CutiDetail {
	
	@JsonProperty("idKaryawan")
	private Long idKaryawan;
	
	@JsonProperty("tanggalMulai")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date tanggalMulai;

    @JsonProperty("tanggalSampai")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date tanggalSampai;
    
    @JsonProperty("idKategori")
    private Integer idKategori;

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

	public Integer getIdKategori() {
		return idKategori;
	}

	public void setIdKategori(Integer idKategori) {
		this.idKategori = idKategori;
	}

	public Long getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(Long idKaryawan) {
		this.idKaryawan = idKaryawan;
	} 
    

}
