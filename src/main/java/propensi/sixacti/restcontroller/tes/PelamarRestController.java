package propensi.sixacti.restcontroller.tes;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.service.tes.PelamarRestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api/pelamar")
public class PelamarRestController {
    @Autowired
    private PelamarRestService pelamarRestService;

    @GetMapping(value="/get/{idPelamar}")
    public PelamarModel getPelamar(
        @PathVariable (value = "idPelamar") Long idPelamar) {
            try{
                return pelamarRestService.getPelamarByIdPelamar(idPelamar);
            }catch(NoSuchElementException e){
                throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Tes Medis " + String.valueOf(idPelamar+ " Not Found"
                ));
            }
    }
    
}