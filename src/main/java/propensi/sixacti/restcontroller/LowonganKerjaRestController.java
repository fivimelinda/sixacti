package propensi.sixacti.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.service.LowonganKerjaService;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class LowonganKerjaRestController {

    @Autowired
    private LowonganKerjaService lowonganKerjaService;

    @GetMapping(value = "/listLoker")
    private List<LowonganKerjaModel> retrieveListLoker(){
        return lowonganKerjaService.getListLowonganKerja();
    }

    @DeleteMapping(value = "/hapusLoker/{idLowongan}")
    private ResponseEntity<String> deleteLoker(@PathVariable("idLowongan") Long idLowongan){
        try{
            lowonganKerjaService.deleteLowonganKerja(idLowongan);
            return ResponseEntity.ok("Loker with Id " + idLowongan + " Deleted");
        }

        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Loker with id " + idLowongan + " Not Found"
            );
        }


    }



}
