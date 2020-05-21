package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.model.NpwpModel;
import propensi.sixacti.service.LamaranService;
import propensi.sixacti.service.NpwpService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class NpwpRestController {
    @Autowired
    NpwpService npwpService;
    @Autowired
    LamaranService lamaranService;

    @PostMapping("/uploadNpwp/{idLamaran}")
    public ResponseEntity<String> uploadKtp(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        NpwpModel npwpModel = npwpService.storeFile(lamaranModel, file);
        return ResponseEntity.ok("NPWP with ID " + file.getOriginalFilename() + " Has been upload");
    }

    @GetMapping("/download/npwp/{fileName}")
    public ResponseEntity downloadFromDB(@PathVariable String fileName) {
        NpwpModel document = npwpService.getFileByName(fileName);
//        BerkasModel berkas = new BerkasModel(document.getFileName(), decompressBytes(document.getData()));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .contentLength(document.getData().length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getData()));
    }
}
