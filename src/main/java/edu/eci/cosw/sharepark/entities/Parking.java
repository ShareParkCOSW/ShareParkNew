package edu.eci.cosw.sharepark.entities;

import java.util.ArrayList;

/**
 * Created by alejandra on 27/09/16.
 */
public class Parking {

    private Integer ownerId=null;
    private boolean covert=false;
    private boolean home=false;
    private ArrayList<AvailabilityDay> schedule=new ArrayList<AvailabilityDay>();
    private Integer costMinute=null;
    private String location=null;
    private Integer stratum=null;
    private String foto=null;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isCovert() {return covert;}

    public void setCovert(boolean covert) {this.covert = covert;}

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public ArrayList<AvailabilityDay> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<AvailabilityDay> schedule) {
        this.schedule = schedule;
    }

    public Integer getCostMinute() {
        return costMinute;
    }

    public void setCostMinute(Integer costMinute) {
        this.costMinute = costMinute;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getStratum() {
        return stratum;
    }

    public void setStratum(Integer stratum) {
        this.stratum = stratum;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
