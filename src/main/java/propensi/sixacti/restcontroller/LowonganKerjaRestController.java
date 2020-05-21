package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.service.LowonganKerjaService;
import propensi.sixacti.service.RequestLowonganService;


import java.util.ArrayList;
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

    @GetMapping(value = "/lowonganPelamar/{nik}")
    private List<LowonganKerjaModel> getLowonganByPelamar(@PathVariable String nik){
        List<LowonganKerjaModel> myList = new ArrayList<>();
        List<LowonganKerjaModel> lokerList = lowonganKerjaService.getListLowonganKerja();
        for(LowonganKerjaModel i : lokerList){
            for (LamaranModel j : i.getListLamaran()){

                if (j.getNik().equals(nik)){

                    myList.add(i);
                }
            }
        } return myList;
    }
    @GetMapping(value = "/getIdPelamar/{idLowongan}/{nik}")
    private Long cekPelamar(@PathVariable Long idLowongan,
                            @PathVariable String nik){
//        List<String> myList = new ArrayList<>();
        LowonganKerjaModel lowonganKerjaModel = lowonganKerjaService.getLowonganKerjaById(idLowongan);

        for (LamaranModel j : lowonganKerjaModel.getListLamaran()){

            if (j.getNik().equals(nik)){

                return j.getPelamar().getIdPelamar();
            }
        } return Long.valueOf(0);
    }


}
