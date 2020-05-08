package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.service.LowonganKerjaService;
import propensi.sixacti.service.RequestLowonganService;


import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class LowonganKerjaRestController {

    @Autowired
    private LowonganKerjaService lowonganKerjaService;

    @Autowired
    private RequestLowonganService requestLowonganService;

    @GetMapping(value = "detailLoker/{idLowongan}")
    private LowonganKerjaModel getLokerById(@PathVariable Long idLowongan){
        return lowonganKerjaService.getLowonganKerjaById(idLowongan);
    }
    
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

//    @PutMapping(value = "/hapusLoker/{idLowongan}")
//    private LowonganKerjaModel deleteLoker(@PathVariable Long idLowongan, @RequestBody LowonganKerjaModel loker){
//        try{
//            return lowonganKerjaService.deleteLowonganKerja(idLowongan, loker);
//
//        }
//        catch (NoSuchElementException e){
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "ID Lowongan" + idLowongan + "Not Found"
//            );
//        }
//    }

    @PutMapping(value = "/ubahLoker/{idLowongan}")
    private LowonganKerjaModel updateLoker(@PathVariable Long idLowongan, @RequestBody LowonganKerjaModel loker){
        try{
            return lowonganKerjaService.changeLowonganKerja(idLowongan, loker);

        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Lowongan" + idLowongan + "Not Found"
            );
        }
    }


    /*Untuk addLoker, nunggu requestLoker dulu Nanti di serviceLokerIMPLnya
    yang add parameternya req.Loker id, dicari terus oper oper data. save
     */
    @PostMapping(value = "/addLoker/{idReqLowongan}")
    private ResponseEntity<Void> createLoker(@PathVariable Long idReqLowongan, @RequestBody LowonganKerjaModel loker, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }else{
            RequestLowonganModel reqLoker = requestLowonganService.getRequestLowonganById(idReqLowongan);
            reqLoker.setStatus("Diterima");
            loker.setDepartement(reqLoker.getDepartement());
            loker.setSection(reqLoker.getSection());
            loker.setDeleted(false);
            loker.setRequestLowongan(reqLoker);
            lowonganKerjaService.addLowonganKerja(loker);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



}
