package propensi.sixacti.restcontroller.tes;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.TesTulisModel;

import propensi.sixacti.service.tes.PelamarRestService;
import propensi.sixacti.service.tes.tesTulis.TesTulisRestService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/tes")
public class TesTulisRestController {

    @Autowired
    private TesTulisRestService tesTulisRestService;

    @Autowired
    private PelamarRestService pelamarRestService;

    @PostMapping(value = "/tulis/{idPelamar}")
    public TesTulisModel tambahTesTulis(
        @Valid @RequestBody TesTulisModel tesTulis,
        @PathVariable (value = "idPelamar") Long idPelamar,
        BindingResult bindingResult
    )
    {   
        //TODO: process POST request
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            tesTulis.setPelamarTesTulis(pelamar);
            return tesTulisRestService.buatTesTulis(tesTulis);
        }
    }

    @GetMapping(value = "/tulis/pelamar/{idPelamar}")
    public TesTulisModel getTesTulisByPelamar(
        @PathVariable (value = "idPelamar") Long idPelamar
    ){
        try{
            PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            return tesTulisRestService.getTesTulisByPelamar(pelamar);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tes Tulis Not Found"
            );
        }
    }

    @GetMapping(value = "/tulis/get/{idTesTulis}")
    public TesTulisModel getTesTulis(
        @PathVariable (value = "idTesTulis") Long idTesTulis
    ){
        try{
            return tesTulisRestService.getTesTulisByIdTesTulis(idTesTulis);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Tes Tulis " + String.valueOf(idTesTulis+ " Not Found"
            ));
        }
    }

    @PutMapping(value = "/tulis/update/{idTesTulis}")
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