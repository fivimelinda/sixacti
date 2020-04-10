package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.KtpService;
import propensi.sixacti.service.LamaranService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class KtpRestController {
    @Autowired
    KtpService ktpService;

    @Autowired
    LamaranService lamaranService;

    @PostMapping("/uploadKtp/{idLamaran}")
    public ResponseEntity<String> uploadKtp(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        KtpModel ktpModel = ktpService.storeFile(lamaranModel, file);
        
        return ResponseEntity.ok("KTP with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
