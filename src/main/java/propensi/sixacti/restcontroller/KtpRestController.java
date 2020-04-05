package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.service.KtpService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class KtpRestController {
    @Autowired
    KtpService ktpService;

    @PostMapping("/uploadKtp")
    public ResponseEntity<String> uploadKtp(@RequestParam("file") MultipartFile file){
        KtpModel ktpModel = ktpService.storeFile(file);
        return ResponseEntity.ok("KTP with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
