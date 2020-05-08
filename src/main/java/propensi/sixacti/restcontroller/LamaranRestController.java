package propensi.sixacti.restcontroller;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.repository.PelamarDB;
import propensi.sixacti.service.*;
import propensi.sixacti.service.tes.PelamarRestService;


import javax.swing.*;
import java.sql.Timestamp;
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
    @Autowired
    private PelamarService pelamarService;
    @Autowired
    private UserService userService;
    @Autowired
    private PelamarRestService pelamarRestService;

    @PostMapping(value = "/addLamaran/{idLowongan}")
    private ResponseEntity<Long> createLamaran(@PathVariable Long idLowongan, @RequestBody LamaranModel lamaranModel, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }else{
            LowonganKerjaModel lowonganKerjaModel = lowonganKerjaService.getLowonganKerjaById(idLowongan);
            lamaranModel.setLowongan(lowonganKerjaModel);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            lamaranModel.setTimestampPelamar(timestamp);
            lamaranService.addLamaran(lamaranModel);
            return ResponseEntity.ok(lamaranModel.getId());
//            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

//    @GetMapping(value = "/listLamaran/{idLowongan}")
//    private List<LamaranModel> getLamaranByIdLowongan(@PathVariable Long idLowongan){
//        return lamaranService.getLamaranByLowonganId(idLowongan);
//    }




}
