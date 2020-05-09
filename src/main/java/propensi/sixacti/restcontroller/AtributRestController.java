package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import propensi.sixacti.model.AtributModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.service.AtributService;
import propensi.sixacti.service.KaryawanService;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class AtributRestController {

    @Autowired
    AtributService atributService;

    @Autowired
    KaryawanService karyawanService;

    @GetMapping(value = "/detailAtribut/{id_atribut}")
    private AtributModel getAtributById(@PathVariable Long id_atribut){
        return atributService.getAtributById(id_atribut);
    }

    @GetMapping(value = "/listAtribut")
    private List<AtributModel> retrieveListAtribut(){
        return atributService.getListAtribut();
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

    @GetMapping(value = "/user/{id_karyawan}")
    private String getUser(@PathVariable Long id_karyawan){
        KaryawanModel karyawanModel = karyawanService.getKaryawanById(id_karyawan);
        return karyawanModel.getUser().getNama();
    }
}