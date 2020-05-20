package propensi.sixacti.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KaryawanDetail {
	@JsonProperty("nik")
	private String nik;
	
	@JsonProperty("gaji")
	private Integer gaji;
	
	@JsonProperty("sisaCuti")
	private Integer sisaCuti;
	
	@JsonProperty("idDept")
	private Long idDept;
	
	@JsonProperty("idSect")
	private Long idSect;

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public Integer getGaji() {
		return gaji;
	}

	public void setGaji(Integer gaji) {
		this.gaji = gaji;
	}

	public Integer getSisaCuti() {
		return sisaCuti;
	}

	public void setSisaCuti(Integer sisaCuti) {
		this.sisaCuti = sisaCuti;
	}

	public Long getIdDept() {
		return idDept;
	}

	public void setIdDept(Long idDept) {
		this.idDept = idDept;
	}

	public Long getIdSect() {
		return idSect;
	}

	public void setIdSect(Long idSect) {
		this.idSect = idSect;
	}
	
	
	
}
