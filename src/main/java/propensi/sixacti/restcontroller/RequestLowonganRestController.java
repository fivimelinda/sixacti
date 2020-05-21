package propensi.sixacti.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.model.Users;
import propensi.sixacti.service.KaryawanService;
import propensi.sixacti.service.RequestLowonganService;
import propensi.sixacti.service.UsersService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080","http://sixacti.herokuapp.com/" })
@RestController
@RequestMapping("/request")

public class RequestLowonganRestController {
    @Autowired
    private RequestLowonganService  requestLowonganService;

    @Autowired
    KaryawanService karyawanService;

    @Autowired
    UsersService usersService;

    @CrossOrigin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    private List<RequestLowonganModel> retrieveListUser(){
        return requestLowonganService.retrieveListRequestLowongan();
    }

    @CrossOrigin
    @RequestMapping(value = "/get/{id}")
    private RequestLowonganModel getRequestLowonganById(@PathVariable("id") Long id){
        return requestLowonganService.getRequestLowonganById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{id}")
    private Users getUsers(@PathVariable("id") Long id){
        return usersService.getUsersById(id);
    }

    @CrossOrigin
    @PostMapping(value = "/add/{id}")
    private RequestLowonganModel addRequestLowongan(@PathVariable("id") Long id, @Valid @RequestBody RequestLowonganModel requestLowongan, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");

        } else {
            if(requestLowongan.getJobTitle().matches("^.*[^a-zA-Z0-9 ].*$")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getJobTitle().matches("[0-9]+")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getSection().matches("^.*[^a-zA-Z0-9 ].*$")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getSection().matches("[0-9]+")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getDepartement().matches("^.*[^a-zA-Z0-9 ].*$")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getDepartement().matches("[0-9]+")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getSupervisor().matches("^.*[^a-zA-Z0-9 ].*$")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getSupervisor().matches("[0-9]+")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getNamaReplacement().matches("^.*[^a-zA-Z0-9 ].*$")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            if(requestLowongan.getNamaReplacement().matches("[0-9]+")){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
            }
            else{
               Users users = getUsers(id);
                // if(karyawan == null){
                //     karyawanService
                // }
                requestLowongan.setUsers(users);
                return requestLowonganService.addRequestLowongan(requestLowongan);
            }
            // mekanismennya nanti diubah pas udh ada login di front end
           
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    private String RequestLowonganModel(@PathVariable("id") Long id){
        // try{
        //     requestLowonganService.deleteRequestLowonganById(id);
        //     return "success";
        // }
        // catch (Exception e){
        //     return "error";
        // }
        requestLowonganService.deleteRequestLowonganById(id);
        return "success";
    }



}
