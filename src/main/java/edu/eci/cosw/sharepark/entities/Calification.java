package edu.eci.cosw.sharepark.entities;

import edu.eci.cosw.sharepark.entities.User;

import javax.persistence.Column;
import javax.persistence.Entity;
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
