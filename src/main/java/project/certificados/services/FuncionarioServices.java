package project.certificados.services;

import project.certificados.entities.Funcionario;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface FuncionarioServices {
    public List<Funcionario> getFuncionarios();
    public void addFuncionario(Funcionario funcionario);
    public Funcionario getFuncionario(Integer id);
    public void updateFuncionario(Funcionario funcionario);
}
