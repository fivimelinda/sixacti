package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.KisModel;
import propensi.sixacti.service.KisService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class KisRestController {
    @Autowired
    KisService kisService;

    @PostMapping("/uploadKis")
    public ResponseEntity<String> uploadKis(@RequestParam("file") MultipartFile file){
        KisModel kisModel = kisService.storeFile(file);
        return ResponseEntity.ok("Kis with ID " + file.getOriginalFilename() + " Has been upload");
    }

}
