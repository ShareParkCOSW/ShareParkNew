package edu.eci.cosw.sharepark.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by alejandra on 20/10/16.
 */
@Entity
@Table(name = "requests")
public class Request implements Serializable{
    public Request() {
    }

    private Boolean state= false;
    private Integer service_paid=null;
    private Integer id=null;
    private Integer giver_id=null;
    private Integer taker_id=null;

    @Column(name = "giver_id")
    public Integer getGiver_id() {
        return giver_id;
    }

    public void setGiver_id(Integer giver_id) {
        this.giver_id = giver_id;
    }

    @Column(name = "taker_id")
    public Integer getTaker_id() {
        return taker_id;
    }

    public void setTaker_id(Integer taker_id) {
        this.taker_id = taker_id;
    }

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

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
