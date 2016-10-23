package edu.eci.cosw.sharepark.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by Andrés Felipe on 12/09/2016.
 */
@Entity
@Table(name = "users")
public class User {
    public User() {
    }

    private String firstName=null;
    private String lastName=null;
    private Integer id=null;
    private String email=null;
    private String address=null;
    private Integer phone=null;
    //Por ahora, la contraseña del usuario sera una propiedad de si mismo:
    private String password=null;
    private List<CreditCard> creditCards=new ArrayList<>();
    private List<Calification> calificationsGive=new ArrayList<>();
    private List<Calification> calificationsTake=new ArrayList<>();
    private List<Vehicle> vehicles=new ArrayList<>();
    private List<Request> requestsGive=new ArrayList<>();
    private List<Request> requestsTake=new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner_id", targetEntity = Parking.class)
    public List<Parking> getParkings() {
        return parkings;
    }

    public void setParkings(List<Parking> parkings) {
        this.parkings = parkings;
    }

    private List<Parking> parkings=new ArrayList<>();


    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner_id", targetEntity = CreditCard.class)
    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "giver_id", targetEntity = Calification.class)
    public List<Calification> getCalificationsGive() {
        return calificationsGive;
    }

    public void setCalificationsGive(List<Calification> calificationsGive) {
        this.calificationsGive = calificationsGive;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "taker_id", targetEntity = Calification.class)

    public List<Calification> getCalificationsTake() {
        return calificationsTake;
    }

    public void setCalificationsTake(List<Calification> calificationsTake) {
        this.calificationsTake = calificationsTake;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "giver_id", targetEntity = Request.class)

    public List<Request> getRequestsGive() {
        return requestsGive;
    }

    public void setRequestsGive(List<Request> requestsGive) {
        this.requestsGive = requestsGive;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "taker_id", targetEntity = Request.class)
    public List<Request> getRequestsTake() {
        return requestsTake;
    }

    public void setRequestsTake(List<Request> requestsTake) {
        this.requestsTake = requestsTake;
    }

    public void addCreditCard(CreditCard cr){
        this.creditCards.add(cr);
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner_id", targetEntity = Vehicle.class)

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
