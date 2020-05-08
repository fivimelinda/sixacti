package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKesehatanModel;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.BpjsKesehatanService;
import propensi.sixacti.service.LamaranService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class BpjsKesehatanRestController {
    @Autowired
    BpjsKesehatanService bpjsKesehatanService;
    @Autowired
    LamaranService lamaranService;

    @PostMapping("/uploadBpjsKesehatan/{idLamaran}")
    public ResponseEntity<String> uploadBpjsKesehatan(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        BpjsKesehatanModel bpjsKesehatanModel = bpjsKesehatanService.storeFile(lamaranModel, file);
        return ResponseEntity.ok("Bpjs Kesehatan with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
