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
import propensi.sixacti.model.TesWawancaraModel;
import propensi.sixacti.service.tes.PelamarRestService;
import propensi.sixacti.service.tes.tesWawancara.TesWawancaraRestService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/tes")
public class TesWawancaraRestController {

    @Autowired
    private TesWawancaraRestService tesWawancaraRestService;

    @Autowired
    private PelamarRestService pelamarRestService;

    //tambah tes wawancara
    @PostMapping(value = "/wawancara/{idPelamar}")
    public TesWawancaraModel tambahTesWawancara(
        @Valid @RequestBody TesWawancaraModel tesWawancara,
        @PathVariable (value = "idPelamar") Long idPelamar,
        BindingResult bindingResult
    ){
        //TODO: process POST request
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            pelamar.setTesWawancara(tesWawancara);
            tesWawancara.setPelamarTesWawancara(pelamar);
            return tesWawancaraRestService.buatTesWawancara(tesWawancara);
        }
    }

    @GetMapping(value = "/wawancara/pelamar/{idPelamar}")
    public TesWawancaraModel getTesWawancaraByPelamar(
        @PathVariable (value = "idPelamar") Long idPelamar
    ){
        try{
            PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            return tesWawancaraRestService.getTesWawancaraByPelamar(pelamar);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tes Wawancara Not Found"
            );
        }
    }

    @GetMapping(value = "/wawancara/get/{idTesWawancara}")
    public TesWawancaraModel getTesWawancara(
        @PathVariable (value = "idTesWawancara") Long idTesWawancara
    ){
        try{
            return tesWawancaraRestService.getTesWawancaraByIdTesWawancara(idTesWawancara);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Tes Wawancara " + String.valueOf(idTesWawancara+ " Not Found"
            ));
        }
    }

    //ubah tes wawancara
    @PutMapping(value = "/wawancara/update/{idTesWawancara}")
    public TesWawancaraModel ubahTesWawancara(
        @PathVariable (value = "idTesWawancara") Long idTesWawancara,
        @RequestBody TesWawancaraModel tesWawancara
    ){
        try{
            return tesWawancaraRestService.ubahTesWawancara(idTesWawancara, tesWawancara);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Tes Wawancara " + String.valueOf(idTesWawancara+ " Not Found"
            ));
        }
    }
}
