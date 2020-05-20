package propensi.sixacti.restcontroller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.DepartemenModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.SectionModel;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.rest.KaryawanDetail;
import propensi.sixacti.service.DeptService;
import propensi.sixacti.service.KaryawanService;
import propensi.sixacti.service.SectionService;
import propensi.sixacti.service.UserService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8081", "http://localhost:8080" })
@RestController
@RequestMapping(value = "/api/karyawan")
public class KaryawanController {
	@Autowired
	private KaryawanService karyawanService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private SectionService sectionService;
	
	@GetMapping(value="/getNama")
	private String getNama(@RequestParam("karyawanId") Long karyawanId) {
		try {
			KaryawanModel target = karyawanService.getKaryawanById(karyawanId);
			return target.getUser().getNama();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/tambah")
	private KaryawanModel tambahTesWawancara(
		@Valid @RequestBody KaryawanDetail karyawan,
		BindingResult bindingResult
	){
		if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
        	try {
        		UserModel user = userService.getuserByNIK(karyawan.getNik());
        		KaryawanModel target = new KaryawanModel();
        		target.setUser(user);
        		target.setGaji(karyawan.getGaji());
        		target.setSisaCuti(karyawan.getSisaCuti());
        		SectionModel section = sectionService.getSectionById(karyawan.getIdSect());
        		DepartemenModel dept = deptService.getDeptById(karyawan.getIdDept());
        		target.setDepartemen(dept);
        		target.setSection(section);
        		return karyawanService.buatKaryawan(target);
        	} catch (NoSuchElementException e){
        		throw new ResponseStatusException(
    					HttpStatus.NOT_FOUND);
        	}
            
        }
	}
	
	@GetMapping(value= "/get/{nik}")
	private KaryawanModel retrieve(@PathVariable("nik") String nik) {
		try {
			UserModel user = userService.getuserByNIK(nik);
			try {
				KaryawanModel target = user.getKaryawan();
				return target;
			} catch (NullPointerException e) {
				return null;
			}
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/edit/{nik}")
	private KaryawanModel edit(@PathVariable("nik") String nik, 
			@Valid @RequestBody KaryawanDetail karyawan, BindingResult bindingResult) {
		try {
			UserModel user = userService.getuserByNIK(nik);
			KaryawanModel target = user.getKaryawan();
    		target.setGaji(karyawan.getGaji());
    		target.setSisaCuti(karyawan.getSisaCuti());
    		SectionModel section = sectionService.getSectionById(karyawan.getIdSect());
    		DepartemenModel dept = deptService.getDeptById(karyawan.getIdDept());
    		target.setDepartemen(dept);
    		target.setSection(section);
			karyawanService.addKaryawan(target);
			return target;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND);
		}
	}

}
