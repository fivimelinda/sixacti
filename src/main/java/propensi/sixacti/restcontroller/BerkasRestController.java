package propensi.sixacti.restcontroller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.BerkasService;
import propensi.sixacti.service.LamaranService;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class BerkasRestController {
    @Autowired
    BerkasService berkasService;

    @Autowired
    LamaranService lamaranService;

    @PostMapping("/uploadFile/{idLamaran}")
    public ResponseEntity<String> uploadFile(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        BerkasModel berkasModel = berkasService.storeFile(lamaranModel, file);
//        berkasModel.setLamaran(lamaranModel);
        return ResponseEntity.ok("Berkas with ID " + file.getOriginalFilename() + " Has been upload");
    }

}
