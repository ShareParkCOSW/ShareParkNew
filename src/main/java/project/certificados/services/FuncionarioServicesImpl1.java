package project.certificados.services;

import project.certificados.entities.Funcionario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class FuncionarioServicesImpl1 implements FuncionarioServices{


    private List<Funcionario> funcionarios=new ArrayList<>();
    @Override
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    @Override
    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public Funcionario getFuncionario(Integer id) {
        Funcionario ans=null;
        for (Funcionario funcionario:funcionarios) {
            if(funcionario.getIdFuncionario()==id){
                ans=funcionario;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) {
        for (Funcionario funcionario0 : funcionarios) {
            if(funcionario0.getIdFuncionario()==funcionario.getIdFuncionario()){
                funcionario0=funcionario;
                break;
            }
        }
    }
}
