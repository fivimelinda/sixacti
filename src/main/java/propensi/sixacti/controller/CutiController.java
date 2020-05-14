package propensi.sixacti.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.CutiModel;
import propensi.sixacti.model.DepartemenModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.KategoriCutiModel;
import propensi.sixacti.model.SectionModel;
import propensi.sixacti.rest.CutiDetail;
import propensi.sixacti.service.CutiService;
import propensi.sixacti.service.KaryawanService;
import propensi.sixacti.service.KategoriCutiService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8081", "http://localhost:8080" })
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
				KaryawanModel karyawan = karyawanService.getKaryawanById(cuti.getIdKaryawan());
				CutiModel newCuti = new CutiModel();
				newCuti.setKaryawan(karyawan);
				newCuti.setStatus("Diajukan");
				newCuti.setTanggalDiajukan(new Date());
				newCuti.setTanggalMulai(cuti.getTanggalMulai());
				newCuti.setTanggalSampai(cuti.getTanggalSampai());
				newCuti.setKeterangan(cuti.getKeterangan());
				KategoriCutiModel kategori = kategoriCutiService.getKategoriById(cuti.getIdKategori()).get();
				newCuti.setKategori(kategori);
				cutiService.addCuti(newCuti);
				karyawan.getCuti().add(newCuti);
				return cuti;
			} catch (NoSuchElementException e) {
				throw new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Karyawan not found!");
			}
		}
	}
	
	@DeleteMapping(value="/api/cuti/hapus")
	private ResponseEntity<String> deleteCuti(@RequestParam("cutiId") Long cutiId){
		try {
			CutiModel cuti = cutiService.getCutiById(cutiId).get();
			if(cuti.getStatus().contentEquals("Diajukan")) {
				cutiService.deleteCuti(cuti);
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		} catch (Exception e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Cuti not found!");
		}
	}
	
	@PutMapping(value="/api/cuti/update")
	private ResponseEntity<String> updateCuti(
			@RequestParam("idCuti") Long cutiId,
			@Valid @RequestBody CutiDetail newCuti, BindingResult bindingResult) {
		try {
			CutiModel editCuti = cutiService.getCutiById(cutiId).get();
			editCuti.setTanggalMulai(newCuti.getTanggalMulai());
			editCuti.setTanggalSampai(newCuti.getTanggalSampai());
			KategoriCutiModel newKategori = kategoriCutiService.getKategoriById(newCuti.getIdKategori()).get();
			editCuti.setKategori(newKategori);
			editCuti.setKeterangan(newCuti.getKeterangan());
			cutiService.addCuti(editCuti);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
				HttpStatus.PRECONDITION_FAILED);
		}
	}
	
//	@GetMapping(value="/api/cuti/get")
//	private CutiModel retrieveCuti(@PathVariable("cutiId") Long cutiId) {
//		try {
//			return cutiService.getCutiById(cutiId).get();
//		} catch (NoSuchElementException e) {
//			throw new ResponseStatusException(
//				HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping(value="/api/cuti/diajukan/get")
	private HashMap<String, String> retrieveCutiDiajukan(@RequestParam("karyawanId") Long karyawanId) {
			KaryawanModel karyawan = karyawanService.getKaryawanById(karyawanId);
			HashMap<String, String> cutiResponse = new HashMap<String, String>();
		try {
			CutiModel cuti = cutiService.getCutiOnProcess(karyawan).get();
			cutiResponse.put("cutiActive", "true");
			cutiResponse.put("idKaryawan", String.valueOf(karyawan.getId()));
			cutiResponse.put("idCuti", String.valueOf(cuti.getId()));
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			cutiResponse.put("tanggalMulai", dateFormat.format(cuti.getTanggalMulai()));
			cutiResponse.put("tanggalSampai", dateFormat.format(cuti.getTanggalSampai()));
			cutiResponse.put("tanggalDiajukan", dateFormat.format(cuti.getTanggalDiajukan()));
			cutiResponse.put("namaKategori", cuti.getKategori().getNamaKategori());
			cutiResponse.put("idKategori", String.valueOf(cuti.getKategori().getId()));
			cutiResponse.put("statusCuti", cuti.getStatus());
			cutiResponse.put("keterangan", cuti.getKeterangan());
		} catch (NoSuchElementException e) {
			cutiResponse.put("cutiActive", "false");
			cutiResponse.put("sisaCuti", String.valueOf(karyawan.getSisaCuti()));
		}return cutiResponse;
	}
	
	@GetMapping(value="/api/cuti/riwayat")
	private List<CutiModel> retrieveRiwayatCuti(@RequestParam("karyawanId") Long karyawanId){
		KaryawanModel karyawan = karyawanService.getKaryawanById(karyawanId);
		try {
			List<CutiModel> listCuti = cutiService.getCutiDoneByKaryawan(karyawan);
			return listCuti;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Riwayat not exist!");
		}
	}
	
	@GetMapping(value="/api/listCuti/unreview")
	private List<CutiModel> allCutiUnreviewed(@RequestParam("reviewerId") Long reviewerId){
		KaryawanModel reviewer = karyawanService.getKaryawanById(reviewerId);
		String statusDicari = "";
		List<KaryawanModel> karyawanFiltered = null;
		String role = reviewer.getRole().getNamaRole().toLowerCase();
		if (role.equals("assistant manager")){
			statusDicari = "Diajukan";
			SectionModel sect = reviewer.getSection();
			karyawanFiltered = sect.getListKaryawan();
		} else if(role.equals("department manager")) {
			statusDicari = "Diproses";
			DepartemenModel dept = reviewer.getDepartemen();
			karyawanFiltered = dept.getListKaryawan();
		}
		
		try {
			List<CutiModel> listCuti = cutiService.getCutiByKaryawanAndStatus(karyawanFiltered, statusDicari);
			return listCuti;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "List Cuti not exist!");
		}
		
	}
	
	@PutMapping(value="/api/cuti/approved")
	private ResponseEntity<String> approveCuti(@RequestParam("cutiId") Long cutiId){
		try {
			CutiModel cutiTarget = cutiService.getCutiById(cutiId).get();
			KaryawanModel karyawanCuti = cutiTarget.getKaryawan();
			String currStat = cutiTarget.getStatus().toLowerCase();
			if (currStat.equals("Diajukan")) {
				cutiTarget.setStatus("Diproses");
			} else if (currStat.equals("Diproses")) {
				cutiTarget.setStatus("Disetujui");
				karyawanCuti.setSisaCuti(karyawanCuti.getSisaCuti()-1);
			}
			cutiService.addCuti(cutiTarget);
			karyawanService.addKaryawan(karyawanCuti);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Cuti not exist!");
		}
	}
	
	@PutMapping(value="/api/cuti/rejected")
	private ResponseEntity<String> rejectCuti(@RequestParam("cutiId") Long cutiId){
		try {
			CutiModel cutiTarget = cutiService.getCutiById(cutiId).get();
			cutiTarget.setStatus("Ditolak");
			cutiService.addCuti(cutiTarget);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Cuti not exist!");
		}
	}
	
}
