package edu.eci.cosw.sharepark.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by alejandra on 20/10/16.
 */
@Entity
@Table(name = "califications")
public class Calification {
    public Calification() {

    }
    private Integer id=null;
    private Integer stars=null;
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

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "stars")
    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
