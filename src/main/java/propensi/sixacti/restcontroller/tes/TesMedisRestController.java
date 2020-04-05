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

import propensi.sixacti.model.TesMedisModel;
import propensi.sixacti.service.tes.tesMedis.TesMedisRestService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api/tes")
public class TesMedisRestController{
    
    @Autowired
    private TesMedisRestService tesMedisRestService;

    // @Autowired
    // private UserRestService userRestService;

    //add new tes medis
    @PostMapping(value="/medis")
    public TesMedisModel tambahTesMedis(
        @Valid @RequestBody TesMedisModel tesMedis,
        BindingResult bindingResult) 
        {
        //TODO: process POST request
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            return tesMedisRestService.buatTesMedis(tesMedis);
        }
    }

    //edit tes
    @PutMapping(value = "/medis/update")
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