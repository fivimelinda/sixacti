package propensi.sixacti.restcontroller;

import javax.validation.Valid;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.Roles;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.model.Users;
import propensi.sixacti.repository.UserDB;
import propensi.sixacti.service.PelamarService;
import propensi.sixacti.service.UserService;
import propensi.sixacti.service.UsersService;
import propensi.sixacti.service.tes.PelamarRestService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/profil")
public class UsersRestController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserService userService;

    @Autowired
    private PelamarService pelamarService;

    @Autowired
    private PelamarRestService pelamarRestService;

    @Autowired
    private UserDB userDb;

    @PutMapping(value = "/setUser/{id}" )
    private Users setUser(@PathVariable("id") Long id, @Valid @RequestBody UserModel userModel,  BindingResult bindingResult){
        // if(bindingResult.hasFieldErrors()){
        //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        // } else {
            userModel.setUsers(usersService.getUsersById(id));
            Users baru =  usersService.setUser(userService.addUser(userModel), id);
            return baru;
    }
    
    @GetMapping(value = "/addPelamar/{nik}")
    private PelamarModel addPelamar(@PathVariable("nik") String nik) {
    	return pelamarService.generatePelamar(nik);
    }

    @GetMapping(value = "/getPelamar/{nik}")
    private PelamarModel getPelamar(@PathVariable("nik") String nik) {
        UserModel user = userDb.findUserModelByNik(nik).orElse(null);
    	return pelamarRestService.getPelamarByUser(user);
    }

    @RequestMapping(value = "/users/{id}")
    private Users getUsers(@PathVariable("id") Long id){
        return usersService.getUsersById(id);
    }

    @PutMapping(value = "/editUser/{id}")
    private Users editUser(@PathVariable("id") Long id, @Valid @RequestBody UserModel userModel,  BindingResult bindingResult){
        return usersService.editUser(userModel, id);
    }

}