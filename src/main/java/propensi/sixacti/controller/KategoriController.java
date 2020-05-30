package propensi.sixacti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import propensi.sixacti.model.KategoriCutiModel;
import propensi.sixacti.service.KategoriCutiService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class KategoriController {
	@Autowired
	private KategoriCutiService kategoriCutiService;
	
	@GetMapping(value="/api/kategoriCuti/get")
	private List<KategoriCutiModel> retrieveListKategori(){
		return
			kategoriCutiService.retrieveListKategori();
	}
}
