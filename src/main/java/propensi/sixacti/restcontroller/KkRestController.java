package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KkModel;
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
        System.out.println(idLamaran);
        System.out.println("------------------------------------------");
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        KkModel kkModel = kkService.storeFile(lamaranModel, file);

        return ResponseEntity.ok("Kk with ID " + file.getOriginalFilename() + " Has been upload");
    }

    @GetMapping("/download/kk/{fileName}")
    public ResponseEntity downloadFromDB(@PathVariable String fileName) {
        KkModel document = kkService.getFileByName(fileName);
//        BerkasModel berkas = new BerkasModel(document.getFileName(), decompressBytes(document.getData()));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .contentLength(document.getData().length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getData()));
    }
}
