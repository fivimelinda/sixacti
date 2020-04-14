package propensi.sixacti.restcontroller.tes;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.TesMedisModel;
import propensi.sixacti.service.tes.PelamarRestService;
import propensi.sixacti.service.tes.tesMedis.TesMedisRestService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/tes")
public class TesMedisRestController{
    
    @Autowired
    private TesMedisRestService tesMedisRestService;

    @Autowired
    private PelamarRestService pelamarRestService;

    //add new tes medis
    @PostMapping(value="/medis/{idPelamar}")
    public TesMedisModel tambahTesMedis(
        @Valid @RequestBody TesMedisModel tesMedis,
        @PathVariable (value = "idPelamar") Long idPelamar,
        BindingResult bindingResult) 
        {
        //TODO: process POST request
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            tesMedis.setPelamarTesMedis(pelamar);
            // pelamarRestService.saveUpdatePelamar(pelamar);
            return tesMedisRestService.buatTesMedis(tesMedis);
        }
    }

    
    //get tes medis
    @GetMapping(value = "/medis/get/{idTesMedis}")
    public TesMedisModel getTesMedis(
        @PathVariable (value = "idTesMedis") Long idTesMedis
    ){
        try{
            return tesMedisRestService.getTesMedisByIdTesMedis(idTesMedis);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Tes Medis " + String.valueOf(idTesMedis+ " Not Found"
            ));
        }
    }

    @GetMapping(value = "/medis/pelamar/{idPelamar}")
    public TesMedisModel getTesMedisByPelamar(
        @PathVariable (value = "idPelamar") Long idPelamar
    ){
        try{
            PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            return tesMedisRestService.getTesMedisByPelamar(pelamar);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tes Medis Not Found"
            );
        }
    }

    //edit tes
    @PutMapping(value = "/medis/update/{idTesMedis}")
    public TesMedisModel ubahTesMedis(
        @PathVariable (value = "idTesMedis") Long idTesMedis,
        @RequestBody TesMedisModel tesMedis
    ){
        try{
            return tesMedisRestService.ubahTesMedis(idTesMedis, tesMedis);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Tes Medis " + String.valueOf(idTesMedis+ " Not Found"
            ));
        }
    }

    //tanpa delete

}