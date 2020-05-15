package propensi.sixacti.restcontroller;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.*;

import propensi.sixacti.service.*;
import propensi.sixacti.service.tes.PelamarRestService;


import javax.swing.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class LamaranRestController {

    @Autowired
    private LamaranService lamaranService;
    @Autowired
    private LowonganKerjaService lowonganKerjaService;
    @Autowired
    private PelamarRestService pelamarRestService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/addLamaran/{idLowongan}")
    private ResponseEntity<Long> createLamaran(@PathVariable Long idLowongan, @RequestBody LamaranModel lamaranModel, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }else{
            LowonganKerjaModel lowonganKerjaModel = lowonganKerjaService.getLowonganKerjaById(idLowongan);
            UserModel user = userService.getuserByNIK("1234567890123456");
            PelamarModel pelamarModel = pelamarRestService.getPelamarByUser(user);

            lamaranModel.setPelamar(pelamarModel);
            lamaranModel.setLowongan(lowonganKerjaModel);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            lamaranModel.setTimestampPelamar(timestamp);

            lamaranService.addLamaran(lamaranModel);
            return ResponseEntity.ok(lamaranModel.getId());
//            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping(value = "/detailLamaran/{id}")
    private LamaranModel getLamaranById(@PathVariable Long id){
        return lamaranService.findByIdLamaran(id);
    }

    @PutMapping(value = "/setStatus/{id}")
    private LamaranModel setStatus(@PathVariable Long id, @RequestBody LamaranModel lamaran){
        try{
            return lamaranService.setStatus(id, lamaran);

        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Lamaran" + id + "Not Found"
            );
        }
    }

//    @GetMapping(value = "/listLamaran/{idLowongan}")
//    private List<LamaranModel> getLamaranByIdLowongan(@PathVariable Long idLowongan){
//        return lamaranService.getLamaranByLowonganId(idLowongan);

}
