package propensi.sixacti.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.service.RequestLowonganService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/request")

public class RequestLowonganRestController {
    @Autowired
    private RequestLowonganService  requestLowonganService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    private List<RequestLowonganModel> retrieveListUser(){
        return requestLowonganService.retrieveListRequestLowongan();
    }

    @RequestMapping(value = "/get/{id}")
    private RequestLowonganModel getRequestLowonganById(@PathVariable("id") Long id){
        return requestLowonganService.getRequestLowonganById(id);
    }



}