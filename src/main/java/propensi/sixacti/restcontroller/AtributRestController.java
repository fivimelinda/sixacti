package propensi.sixacti.restcontroller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.AtributModel;
import propensi.sixacti.repository.AtributDb;
import propensi.sixacti.service.AtributRestService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/atribut")
public class AtributRestController {
    @Autowired
    private AtributDb atributDb;

    @Autowired
    private AtributRestService atributRestService;

    @PostMapping(value="/tambah")
    public AtributModel tambahAtribut(
        @Valid @RequestBody AtributModel atribut,
        // @PathVariable (value = "idPelamar") Long idPelamar,
        BindingResult bindingResult) 
        {
        //TODO: process POST request
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            // PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            // pelamar.setTesMedis(tesMedis);
            // tesMedis.setPelamarTesMedis(pelamar);
            // pelamarRestService.saveUpdatePelamar(pelamar);
            return atributRestService.buatAtribut(atribut);
        }
    }

    @GetMapping(value = "/get/{idAtribut}")
    public AtributModel ubahAtribut(
        @PathVariable (value = "idAtribut") Long idAtribut
    ){
        try{
            return atributRestService.getAtributByIdAtribut(idAtribut);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Atribut " + String.valueOf(idAtribut+ " Not Found"
            ));
        }
    }

    
}