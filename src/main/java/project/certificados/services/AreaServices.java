package project.certificados.services;

import project.certificados.entities.Area;

import java.util.List;

/**
 * Created by Alejandra Goenaga.
 */
public interface AreaServices {
    public List<Area> getAreas();
    public void addArea(Area area);
    public Area getArea(Integer id);
    public void updateArea(Area area);
}
