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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fulfillment")
public class FulfillmentModel implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Temporal(TemporalType.DATE)
    @Column(name="tanggalDiterima", nullable = false)
    private Date tanggalDiterima;
	
	@Column(name="jumlah_lakilaki", nullable = false)
    private Integer jumlahLakilaki;
	
	@Column(name="jumlah_perempuan", nullable = false)
    private Integer jumlahPerempuan;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idLoker", referencedColumnName = "idLowongan", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private LowonganKerjaModel loker;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTanggalDiterima() {
		return tanggalDiterima;
	}

	public void setTanggalDiterima(Date tanggalDiterima) {
		this.tanggalDiterima = tanggalDiterima;
	}

	public Integer getJumlahLakilaki() {
		return jumlahLakilaki;
	}

	public void setJumlahLakilaki(Integer jumlahLakilaki) {
		this.jumlahLakilaki = jumlahLakilaki;
	}

	public Integer getJumlahPerempuan() {
		return jumlahPerempuan;
	}

	public void setJumlahPerempuan(Integer jumlahPerempuan) {
		this.jumlahPerempuan = jumlahPerempuan;
	}

	public LowonganKerjaModel getLoker() {
		return loker;
	}

	public void setLoker(LowonganKerjaModel loker) {
		this.loker = loker;
	} 
	
	
}
