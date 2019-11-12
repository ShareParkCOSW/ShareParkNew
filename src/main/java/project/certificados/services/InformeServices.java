package project.certificados.services;

import project.certificados.entities.Informe;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface InformeServices {
    public List<Informe> getInformes();
    public void addInforme(Informe informe);
    public Informe getInforme(Integer id);
    public void updateInforme(Informe informe);
    public Informe getInformeSpecific(String idEstudiante, Integer año, String curso);
}
