package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.User;

import java.util.List;

/**
 * Created by Andrés Felipe on 12/09/2016.
 */
public interface UserServices {
    public List<User> getUsers();
    public void addUser(User u);
    public User getUser(Integer id);
}
