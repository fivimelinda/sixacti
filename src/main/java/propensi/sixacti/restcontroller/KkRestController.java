package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KkModel;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.KkService;
import propensi.sixacti.service.LamaranService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class KkRestController {
    @Autowired
    KkService kkService;
    @Autowired
    LamaranService lamaranService;

    @PostMapping("/uploadKk/{idLamaran}")
    public ResponseEntity<String> uploadKk(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        KkModel kkModel = kkService.storeFile(lamaranModel, file);

        return ResponseEntity.ok("Kk with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
