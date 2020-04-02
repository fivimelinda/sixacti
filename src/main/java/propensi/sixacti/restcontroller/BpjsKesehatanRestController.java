package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKesehatanModel;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.service.BpjsKesehatanService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class BpjsKesehatanRestController {
    @Autowired
    BpjsKesehatanService bpjsKesehatanService;

    @PostMapping("/uploadBpjsKesehatan")
    public ResponseEntity<String> uploadBpjsKesehatan(@RequestParam("file") MultipartFile file){
        BpjsKesehatanModel bpjsKesehatanModel = bpjsKesehatanService.storeFile(file);
        return ResponseEntity.ok("Bpjs Kesehatan with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
