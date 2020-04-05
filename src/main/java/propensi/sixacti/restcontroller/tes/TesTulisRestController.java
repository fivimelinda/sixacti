package propensi.sixacti.restcontroller.tes;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.TesTulisModel;
import propensi.sixacti.service.tes.tesTulis.TesTulisRestService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api/tes")
public class TesTulisRestController {

    @Autowired
    private TesTulisRestService tesTulisRestService;

    @PostMapping(value = "/tulis")
    public TesTulisModel tambahTesTulis(
        @Valid @RequestBody TesTulisModel tesTulis,
        // @PathVariable(value = "nilai") String nilai,
        // @PathVariable(value = "pelamar") String idPelamar,
        BindingResult bindingResult
    )
    {
        // TesTulisModel tesTulis = new TesTulisModel();
        // tesTulis.setNilai(nilai);
        // tesTulis.setPelamar(null);

        //TODO: process POST request
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            return tesTulisRestService.buatTesTulis(tesTulis);
        }
    }

    @PutMapping(value = "/tulis/update")
    public TesTulisModel ubahTesTulis(
        @PathVariable (value = "idTesTulis") Long idTesTulis,
        @RequestBody TesTulisModel tesTulis
    ){
        try{
            return tesTulisRestService.ubahTesTulis(idTesTulis, tesTulis);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Tes Tulis " + String.valueOf(idTesTulis+ " Not Found"
            ));
        }
    }
}