package project.certificados.services;

import project.certificados.entities.Informe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class InformeServicesImpl1 implements InformeServices{


    private List<Informe> informes=new ArrayList<>();
    @Override
    public List<Informe> getInformes() {
        return informes;
    }

    @Override
    public void addInforme(Informe informe) {
        informes.add(informe);
    }

    @Override
    public Informe getInforme(Integer id) {
        Informe ans=null;
        for (Informe informe:informes) {
            if(informe.getIdInforme()==id){
                ans=informe;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateInforme(Informe informe) {
        for (Informe informe0 : informes) {
            if(informe0.getIdInforme()==informe.getIdInforme()){
                informe0=informe;
                break;
            }
        }
    }

    @Override
    public Informe getInformeSpecific(Integer idEstudiante, Integer año, String curso) {
        Informe ans=null;
        for (Informe informe0 : informes) {
            if(informe0.getIdEstudiante()==idEstudiante && informe0.getAnio()==año && informe0.getCurso()==curso){
                ans=informe0;
                break;
            }
        }
        return ans;
    }

}
