package project.certificados.services;

import project.certificados.entities.Area;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandra.
 */
//@Service
public class AreaServicesImpl1 implements AreaServices{


    private List<Area> areas=new ArrayList<>();
    @Override
    public List<Area> getAreas() {
        return areas;
    }

    @Override
    public void addArea(Area area) {
        areas.add(area);
    }

    @Override
    public Area getArea(Integer id) {
        Area ans=null;
        for (Area area:areas) {
            if(area.getIdArea()==id){
                ans=area;
                break;
            }
        }
        return ans;
    }

    @Override
    public Area getArea(String nombre) {
        Area ans=null;
        for (Area area:areas) {
            if(area.getNombre()==nombre){
                ans=area;
                break;
            }
        }
        return ans;
    }

    @Override
    public void updateArea(Area area) {
        for (Area area0 : areas) {
            if(area0.getIdArea()==area.getIdArea()){
                area0=area;
                break;
            }
        }
    }
}
