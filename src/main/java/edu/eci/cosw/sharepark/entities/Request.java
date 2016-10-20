package edu.eci.cosw.sharepark.entities;

import edu.eci.cosw.sharepark.entities.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by alejandra on 20/10/16.
 */
@Entity
@Table(name = "requests")
public class Request {
    public Request() {
    }

    private Boolean state= false;
    private Integer service_paid=null;
    private Integer id=null;

    @Column(name = "state")
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Column(name = "service_paid_cost")
    public Integer getService_paid() {
        return service_paid;
    }

    public void setService_paid(Integer service_paid) {
        this.service_paid = service_paid;
    }

    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
