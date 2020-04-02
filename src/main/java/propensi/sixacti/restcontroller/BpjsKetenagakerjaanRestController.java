package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.KkModel;
import propensi.sixacti.service.BpjsKetenagakerjaanService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class BpjsKetenagakerjaanRestController {
    @Autowired
    BpjsKetenagakerjaanService bpjsKetenagakerjaanService;

    @PostMapping("/uploadBpjsKetenagakerjaan")
    public ResponseEntity<String> uploadBpjsKetenagakerjaan(@RequestParam("file") MultipartFile file){
        BpjsKetenagakerjaanModel bpjsKetenagakerjaanModel = bpjsKetenagakerjaanService.storeFile(file);
        return ResponseEntity.ok("Bpjs Ketenagakerjaan with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
