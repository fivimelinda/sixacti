package propensi.sixacti.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.service.RequestLowonganService;

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