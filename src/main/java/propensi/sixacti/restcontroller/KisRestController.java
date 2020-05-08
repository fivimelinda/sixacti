package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.KisModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.KisService;
import propensi.sixacti.service.LamaranService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class KisRestController {
    @Autowired
    KisService kisService;
    @Autowired
    LamaranService lamaranService;


    @PostMapping("/uploadKis/{idLamaran}")
    public ResponseEntity<String> uploadKis(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        KisModel kisModel = kisService.storeFile(lamaranModel, file);
        return ResponseEntity.ok("Kis with ID " + file.getOriginalFilename() + " Has been upload");
    }

}
