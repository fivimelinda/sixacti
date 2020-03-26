package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.LamaranService;


import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class LamaranRestController {

    @Autowired
    private LamaranService lamaranService;

    @PostMapping(value = "/addLamaran")
    private ResponseEntity<Void> createLamaran(@RequestBody LamaranModel lamaranModel, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }else{
            lamaranService.addLamaran(lamaranModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



}
