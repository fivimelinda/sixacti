package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.KtpDB;
import propensi.sixacti.service.KtpService;
import propensi.sixacti.service.LamaranService;

import java.io.IOException;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class KtpRestController {
    @Autowired
    KtpService ktpService;

    @Autowired
    LamaranService lamaranService;

    @Autowired
    KtpDB ktpDB;

    @PostMapping("/uploadKtp/{idLamaran}")
    public ResponseEntity<String> uploadKtp(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        KtpModel ktpModel = ktpService.storeFile(lamaranModel, file);

        return ResponseEntity.ok("KTP with ID " + file.getOriginalFilename() + " Has been upload");
    }

//    @PostMapping("/uploadKtp/{idLamaran}")
//    private ResponseEntity uploadToDB(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
//        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
//        KtpModel berkas = new KtpModel();
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        berkas.setFileName(fileName);
//        berkas.setLamaran(lamaranModel);
//        try{
//            berkas.setData(file.getBytes());
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        ktpDB.save(berkas);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("api/download/ktp/")
//                .path(fileName)
//                .toUriString();
//        return ResponseEntity.ok(fileDownloadUri);
//
//    }

    @GetMapping("/download/ktp/{fileName}")
    public ResponseEntity downloadFromDB(@PathVariable String fileName) {
        KtpModel document = ktpService.getFileByName(fileName);
//        BerkasModel berkas = new BerkasModel(document.getFileName(), decompressBytes(document.getData()));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .contentLength(document.getData().length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getData()));
    }
}
