package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.KkModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.BpjsKetenagakerjaanService;
import propensi.sixacti.service.LamaranService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class BpjsKetenagakerjaanRestController {
    @Autowired
    BpjsKetenagakerjaanService bpjsKetenagakerjaanService;
    @Autowired
    LamaranService lamaranService;

    @PostMapping("/uploadBpjsKetenagakerjaan/{idLamaran}")
    public ResponseEntity<String> uploadBpjsKetenagakerjaan(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        BpjsKetenagakerjaanModel bpjsKetenagakerjaanModel = bpjsKetenagakerjaanService.storeFile(lamaranModel, file);

        return ResponseEntity.ok("Bpjs Ketenagakerjaan with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
