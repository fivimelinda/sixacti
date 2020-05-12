package propensi.sixacti.restcontroller;

import java.util.List;
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
import propensi.sixacti.model.AtributModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.service.AtributService;
import propensi.sixacti.service.KaryawanService;

import propensi.sixacti.model.AtributModel;
import propensi.sixacti.repository.AtributDb;
import propensi.sixacti.service.AtributRestService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class AtributRestController {
    @Autowired
    private AtributDb atributDb;

    @Autowired
    private AtributRestService atributRestService;
  
    @Autowired
    AtributService atributService;

    @Autowired
    KaryawanService karyawanService;
    @PostMapping(value="/tambahAtribut")
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

    @GetMapping(value = "/detailAtribut/{id_atribut}")
    private AtributModel getAtributById(@PathVariable Long id_atribut){
        return atributService.getAtributById(id_atribut);
    }

    @GetMapping(value = "/listAtribut")
    private List<AtributModel> retrieveListAtribut(){
        return atributService.getListAtribut();
    }

    @GetMapping(value = "/getUser/{id_karyawan}")
    private String getUser(@PathVariable Long id_karyawan){
        return karyawanService.getKaryawanById(id_karyawan).getUser().getNama();
    }

    @PutMapping(value = "/ubahStatusAtribut/{id_atribut}")
    private AtributModel updateStatus(@PathVariable Long id_atribut, @RequestBody AtributModel atributModel){
        try{
            return atributService.changeStatusAtribut(id_atribut,atributModel);

        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Atribut" + id_atribut + "Not Found"
            );
        }
    }
}