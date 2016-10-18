/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.sharepark.entities;

import javax.persistence.*;
import java.util.HashMap;

/**
 *
 * @author 2101047
 */
@Entity
@Table(name = "vehicles")
public class Vehicle {


    private String plate=null;
    private String brand=null;
    private String model=null;
    private String color=null;
    private HashMap<String,Boolean> vehicleType= new HashMap<String, Boolean>();

    private Integer ownerid=null;

    public Vehicle() {
        vehicleType.put("Automovil", Boolean.FALSE);vehicleType.put("Campero", Boolean.FALSE);vehicleType.put("Camioneta o Pickup", Boolean.FALSE);
        vehicleType.put("Van", Boolean.FALSE);vehicleType.put("Mini van", Boolean.FALSE);
    }

    @Column(name = "plate")
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name="color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(table = "users",name = "id", nullable = false)
    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    @Column(name="type_vehicle")
    public HashMap<String, Boolean> getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(HashMap<String, Boolean> vehicleType) {
        this.vehicleType = vehicleType;
    }

}
