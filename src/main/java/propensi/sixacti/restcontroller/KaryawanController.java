package propensi.sixacti.restcontroller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.service.KaryawanService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8081", "http://localhost:8080" })
@RestController
@RequestMapping(value = "/api/karyawan")
public class KaryawanController {
	@Autowired
	private KaryawanService karyawanService;
	
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
		@Valid @RequestBody KaryawanModel karyawan,
		BindingResult bindingResult
	){
		if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            return karyawanService.buatKaryawan(karyawan);
        }
	}

}
