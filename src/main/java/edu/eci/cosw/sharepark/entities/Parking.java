package edu.eci.cosw.sharepark.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by alejandra on 27/09/16.
 */
@Entity
@Table(name = "parkings")
public class Parking implements Serializable{
    public Parking() {
    }

    private Integer owner_id=null;
    private boolean covert=false;
    private boolean home=false;
    private Float height=null; 
    private Float width=null;
    private Float length=null;
    private boolean available=false;
    private Timestamp serviceStart=null;
    private Timestamp availableFinish=null;
    private Integer costMinute=null;
    private Float x=null;
    private Float y=null;
    private String address=null;
    private Integer stratum=null;
    private String picture=null;

    @Column(name = "owner_id")
    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer ownerId) {
        this.owner_id = ownerId;
    }

    @Column(name = "covert")
    public boolean isCovert() {return covert;}

    public void setCovert(boolean covert) {this.covert = covert;}

    @Column(name = "home")
    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    @Column(name = "available")
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Column(name = "service_start")
    public Timestamp getServiceStart() {
        return serviceStart;
    }

    public void setServiceStart(Timestamp serviceStart) {
        this.serviceStart = serviceStart;
    }

    @Column(name = "available_finish")
    public Timestamp getAvailableFinish() {
        return availableFinish;
    }

    public void setAvailableFinish(Timestamp availableFinish) {
        this.availableFinish = availableFinish;
    }

    @Column(name = "cost_minute")
    public Integer getCostMinute() {
        return costMinute;
    }

    public void setCostMinute(Integer costMinute) {
        this.costMinute = costMinute;
    }

    @Column(name = "height")
    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    @Column(name = "width")
    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    @Column(name = "length")
    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    @Column(name = "x")
    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    @Column(name = "y")
    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Id
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "stratum")
    public Integer getStratum() {
        return stratum;
    }

    public void setStratum(Integer stratum) {
        this.stratum = stratum;
    }

    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

   
}
