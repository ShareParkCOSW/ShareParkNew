package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrés Felipe on 12/09/2016.
 */
public class UserServicesImpl1 implements UserServices{
    private List<User> users=new ArrayList<>();
    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User u) {
        users.add(u);
    }

    @Override
    public User getUser(Integer id) {
        User ans=null;
        for (User u:users) {
            if(u.getId()==id){
                ans=u;
                break;
            }
        }
        return ans;
    }
}
