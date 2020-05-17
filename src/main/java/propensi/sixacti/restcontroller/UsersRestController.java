package propensi.sixacti.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.UserModel;
import propensi.sixacti.model.Users;
import propensi.sixacti.service.UserService;
import propensi.sixacti.service.UsersService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/profil")

public class UsersRestController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PutMapping(value = "/setUser/{id}" )
    private Users setUser(@PathVariable("id") Long id, @Valid @RequestBody UserModel userModel,  BindingResult bindingResult){
        // if(bindingResult.hasFieldErrors()){
        //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        // } else {
            userModel.setUsers(usersService.getUsersById(id));
            return usersService.setUser(userService.addUser(userModel), id);
        
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{id}")
    private Users getUsers(@PathVariable("id") Long id){
        return usersService.getUsersById(id);
    }
}