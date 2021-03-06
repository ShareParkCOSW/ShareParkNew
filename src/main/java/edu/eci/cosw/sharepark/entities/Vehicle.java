/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.sharepark.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author 2101047
 */
@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable{


    private String plate=null;
    private String brand=null;
    private String model=null;
    private String color=null;
    private HashMap<String,Boolean> vehicleType= new HashMap<String, Boolean>();
    private Integer owner_id;

    @Column(name = "owner_id")
    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Vehicle() {
        vehicleType.put("Automovil", Boolean.FALSE);vehicleType.put("Campero", Boolean.FALSE);vehicleType.put("Camioneta o Pickup", Boolean.FALSE);
        vehicleType.put("Van", Boolean.FALSE);vehicleType.put("Mini van", Boolean.FALSE);
    }

    @Id
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


    @Column(name="type_vehicle")
    public String getVehicleType() {
        String ans=null;
        for (String s:vehicleType.keySet()) {
            if(vehicleType.get(s)){
                ans=s;
                break;
            }
        }
        return ans;
    }

    public void setVehicleType(String s) {
        for (String st:vehicleType.keySet()) {
            if(st.equals(s)){
                vehicleType.replace(st, Boolean.TRUE);
                break;
            }
        }
    }

}
