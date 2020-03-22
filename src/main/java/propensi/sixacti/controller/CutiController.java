package propensi.sixacti.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import propensi.sixacti.model.CutiModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.KategoriCutiModel;
import propensi.sixacti.rest.CutiDetail;
import propensi.sixacti.service.CutiService;
import propensi.sixacti.service.KaryawanService;
import propensi.sixacti.service.KategoriCutiService;

@RestController
public class CutiController {
	@Autowired
	private CutiService cutiService;
	
	@Autowired
	private KaryawanService karyawanService;
	
	@Autowired
	private KategoriCutiService kategoriCutiService;
	
	@PostMapping(value="/api/cuti/ajukan")
	private CutiDetail createPinjaman(@Valid @RequestBody CutiDetail cuti, BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
		} else {
			try {
				KaryawanModel karyawan = karyawanService.getKaryawanById(cuti.getIdKaryawan()).get();
				if (karyawan.getSisaCuti()!=0) {
					CutiModel newCuti = new CutiModel();
					newCuti.setKaryawan(karyawan);
					newCuti.setStatus("Diajukan");
					newCuti.setTanggalMulai(cuti.getTanggalMulai());
					newCuti.setTanggalSampai(cuti.getTanggalSampai());
					KategoriCutiModel kategori = kategoriCutiService.getKategoriById(cuti.getIdKategori()).get();
					newCuti.setKategori(kategori);
					cutiService.addCuti(newCuti);
					karyawan.setSisaCuti(karyawan.getSisaCuti()-1);
				}
				return cuti;
			} catch (NoSuchElementException e) {
				throw new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Karyawan not found!");
			}
			
			
			
		}
	}
	
	
	
}
