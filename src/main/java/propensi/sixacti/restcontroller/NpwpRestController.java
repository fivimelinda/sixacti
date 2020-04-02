package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.NpwpModel;
import propensi.sixacti.service.NpwpService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class NpwpRestController {
    @Autowired
    NpwpService npwpService;

    @PostMapping("/uploadNpwp")
    public ResponseEntity<String> uploadKtp(@RequestParam("file") MultipartFile file){
        NpwpModel npwpModel = npwpService.storeFile(file);
        return ResponseEntity.ok("NPWP with ID " + file.getOriginalFilename() + " Has been upload");
    }
}
