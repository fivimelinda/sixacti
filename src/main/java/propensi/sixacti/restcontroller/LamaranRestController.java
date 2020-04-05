package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.service.LamaranService;
import propensi.sixacti.service.LowonganKerjaService;


import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class LamaranRestController {

    @Autowired
    private LamaranService lamaranService;
    @Autowired
    private LowonganKerjaService lowonganKerjaService;

    @PostMapping(value = "/addLamaran/{idLowongan}")
    private ResponseEntity<Void> createLamaran(@PathVariable Long idLowongan, @RequestBody LamaranModel lamaranModel, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }else{
            LowonganKerjaModel lowonganKerjaModel = lowonganKerjaService.getLowonganKerjaById(idLowongan);
            lamaranModel.setLamaran(lowonganKerjaModel);
            lamaranService.addLamaran(lamaranModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



}
