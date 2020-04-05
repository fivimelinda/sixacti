package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KkModel;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.service.KkService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class KkRestController {
    @Autowired
    KkService kkService;

    @PostMapping("/uploadKk")
    public ResponseEntity<String> uploadKk(@RequestParam("file") MultipartFile file){
        KkModel kkModel = kkService.storeFile(file);
        return ResponseEntity.ok("Kk with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
