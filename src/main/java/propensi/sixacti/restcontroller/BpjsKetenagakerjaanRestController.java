package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.KkModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.BpjsKetenagakerjaanService;
import propensi.sixacti.service.LamaranService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class BpjsKetenagakerjaanRestController {
    @Autowired
    BpjsKetenagakerjaanService bpjsKetenagakerjaanService;
    @Autowired
    LamaranService lamaranService;

    @PostMapping("/uploadBpjsKetenagakerjaan/{idLamaran}")
    public ResponseEntity<String> uploadBpjsKetenagakerjaan(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        BpjsKetenagakerjaanModel bpjsKetenagakerjaanModel = bpjsKetenagakerjaanService.storeFile(lamaranModel, file);

        return ResponseEntity.ok("Bpjs Ketenagakerjaan with ID " + file.getOriginalFilename() + " Has been upload");
    }

    @GetMapping("/download/bpjsKet/{fileName}")
    public ResponseEntity downloadFromDB(@PathVariable String fileName) {
        BpjsKetenagakerjaanModel document = bpjsKetenagakerjaanService.getFileByName(fileName);
//        BerkasModel berkas = new BerkasModel(document.getFileName(), decompressBytes(document.getData()));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .contentLength(document.getData().length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getData()));
    }
}
