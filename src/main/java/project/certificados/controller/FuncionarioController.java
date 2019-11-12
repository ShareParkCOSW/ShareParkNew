package project.certificados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.certificados.entities.Funcionario;
import project.certificados.services.FuncionarioServices;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioServices services;

    @RequestMapping(value ="/check", method = RequestMethod.GET)
    public String check(){
        return "REST FUNCIONARIOS FUNCIONA!!";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Funcionario> getFuncionarios(){
        return services.getFuncionarios();
    }

    @RequestMapping(value = "/{idfuncionario}", method = RequestMethod.GET)
    public Funcionario getFuncionario(@PathVariable("idfuncionario") String idfuncionario){
        return services.getFuncionario(idfuncionario);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> postFuncionario(@RequestBody(required = true) Funcionario funcionario){
        services.addFuncionario(funcionario);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateFuncionario(@RequestBody(required = true) Funcionario funcionario){
        services.updateFuncionario(funcionario);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
