package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKesehatanModel;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.BpjsKesehatanService;
import propensi.sixacti.service.LamaranService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class BpjsKesehatanRestController {
    @Autowired
    BpjsKesehatanService bpjsKesehatanService;
    @Autowired
    LamaranService lamaranService;

    @PostMapping("/uploadBpjsKesehatan/{idLamaran}")
    public ResponseEntity<String> uploadBpjsKesehatan(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        BpjsKesehatanModel bpjsKesehatanModel = bpjsKesehatanService.storeFile(lamaranModel, file);
        return ResponseEntity.ok("Bpjs Kesehatan with ID " + file.getOriginalFilename() + " Has been upload");
    }

    @GetMapping("/download/bpjsKes/{fileName}")
    public ResponseEntity downloadFromDB(@PathVariable String fileName) {
        BpjsKesehatanModel document = bpjsKesehatanService.getFileByName(fileName);
//        BerkasModel berkas = new BerkasModel(document.getFileName(), decompressBytes(document.getData()));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .contentLength(document.getData().length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getData()));
    }
}
