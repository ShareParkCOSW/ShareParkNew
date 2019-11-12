package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.Admin;
import project.certificados.services.AdminServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST ADMINS FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Admin> getAdmins(){
        return services.getAdmins();
    }

    @RequestMapping(value = "/{idadmin}", method = RequestMethod.GET)
    public Admin getAdmin(@PathVariable("idadmin") String idadmin){
        return services.getAdmin(idadmin);
    }

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public Admin getAdminByUsernameAndPassword(@PathVariable("username") String username){
        return services.getAdminByUsernameAndPassword(username);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> postAdmin(@RequestBody(required = true) Admin admin){
        services.addAdmin(admin);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateAdmin(@RequestBody(required = true) Admin admin){
        services.updateAdmin(admin);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
