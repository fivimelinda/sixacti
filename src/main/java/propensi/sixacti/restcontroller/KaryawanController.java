package propensi.sixacti.restcontroller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.service.KaryawanService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8081", "http://localhost:8080" })
@RestController
public class KaryawanController {
	@Autowired
	private KaryawanService karyawanService;
	
	@GetMapping(value="/api/karyawan/getNama")
	private String getNama(@RequestParam("karyawanId") Long karyawanId) {
		try {
			KaryawanModel target = karyawanService.getKaryawanById(karyawanId);
			return target.getUser().getNama();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND);
		}
	}

}
