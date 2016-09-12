package edu.eci.cosw.sharepark.controller;

import edu.eci.cosw.sharepark.entities.User;
import edu.eci.cosw.sharepark.services.UserServices;
import edu.eci.cosw.sharepark.services.UserServicesImpl1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Andrés Felipe on 12/09/2016.
 */
@RestController
@RequestMapping("/usuarios")
public class UserController {
    private UserServices services=new UserServicesImpl1();

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST USUARIOS FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){
        return services.getUsers();
    }

    @RequestMapping(value = "/{iduser}", method = RequestMethod.GET)
    public User getUser(@PathVariable("iduser") Integer iduser){
        return services.getUser(iduser);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postUser(@RequestBody(required = true) User u){
        services.addUser(u);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
