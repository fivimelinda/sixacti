package propensi.sixacti.restcontroller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.service.BerkasService;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BerkasRestController {
    @Autowired
    BerkasService berkasService;



    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        BerkasModel berkasModel = berkasService.storeFile(file);
        return ResponseEntity.ok("Berkas with ID " + file.getOriginalFilename() + " Has been upload");
    }

    @PostMapping("/uploadMultipleFiles")
    public List<ResponseEntity<String>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

}
