package propensi.sixacti.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.service.KaryawanService;
import propensi.sixacti.service.RequestLowonganService;

@RestController
@RequestMapping("/request")

public class RequestLowonganRestController {
    @Autowired
    private RequestLowonganService  requestLowonganService;

    @Autowired
    KaryawanService karyawanService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    private List<RequestLowonganModel> retrieveListUser(){
        return requestLowonganService.retrieveListRequestLowongan();
    }

    @RequestMapping(value = "/get/{id}")
    private RequestLowonganModel getRequestLowonganById(@PathVariable("id") Long id){
        return requestLowonganService.getRequestLowonganById(id);
    }

    @PostMapping(value = "/add")
    private RequestLowonganModel addRequestLowongan(@Valid @RequestBody RequestLowonganModel requestLowongan, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");

        } else {
            // System.out.println(requestLowongan);
            KaryawanModel karyawan = karyawanService.getKaryawanById(Long.parseLong("1"));
            requestLowongan.setKaryawan(karyawan);
            return requestLowonganService.addRequestLowongan(requestLowongan);
        }
    }



}