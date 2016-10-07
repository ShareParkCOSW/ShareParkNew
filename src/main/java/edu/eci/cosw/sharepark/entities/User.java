package edu.eci.cosw.sharepark.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrés Felipe on 12/09/2016.
 */
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
    private List<Vehicle> vehicles=new ArrayList<Vehicle>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void addCreditCard(CreditCard cr){
        this.creditCards.add(cr);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
