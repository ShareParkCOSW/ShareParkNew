package edu.eci.cosw.sharepark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by david on 9/12/16.
 */
@RestController
public class SecurityController {

    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }
}