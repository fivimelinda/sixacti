package propensi.sixacti.restcontroller;

import org.slf4j.LoggerFactory;
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
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.BerkasDB;
import propensi.sixacti.service.BerkasService;
import propensi.sixacti.service.LamaranService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class BerkasRestController {
    @Autowired
    BerkasService berkasService;

    @Autowired
    LamaranService lamaranService;

    @Autowired
    BerkasDB berkasDB;

//    @PostMapping("/uploadFile/{idLamaran}")
//    public ResponseEntity<String> uploadFile(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
//        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
//        BerkasModel berkasModel = berkasService.storeFile(lamaranModel, file);
////        berkasModel.setLamaran(lamaranModel);
//        return ResponseEntity.ok("Berkas with ID " + file.getOriginalFilename() + " Has been upload");
//    }

    @PostMapping("uploadFile/{idLamaran}")
    private ResponseEntity uploadToDB(@PathVariable Long idLamaran, @RequestParam("file") MultipartFile file){
        LamaranModel lamaranModel = lamaranService.findByIdLamaran(idLamaran);
        BerkasModel berkas = new BerkasModel();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        berkas.setFileName(fileName);
        berkas.setLamaran(lamaranModel);
        try{
            berkas.setData(file.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }
        berkasDB.save(berkas);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/download/resume/")
                .path(fileName)
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);

    }

    @GetMapping("/download/resume/{fileName}")
    public ResponseEntity downloadFromDB(@PathVariable String fileName) {
        BerkasModel document = berkasService.getFileByName(fileName);
//        BerkasModel berkas = new BerkasModel(document.getFileName(), decompressBytes(document.getData()));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .contentLength(document.getData().length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getData()));
    }

//    public static byte[] decompressBytes(byte[] data) {
//        Inflater inflater = new Inflater();
//        inflater.setInput(data);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//        byte[] buffer = new byte[1024];
//        try {
//            while (!inflater.finished()) {
//                int count = inflater.inflate(buffer);
//                outputStream.write(buffer, 0, count);
//            }
//            outputStream.close();
//        } catch (IOException ioe) {
//        } catch (DataFormatException e) {
//        }
//        return outputStream.toByteArray();
//    }

}
