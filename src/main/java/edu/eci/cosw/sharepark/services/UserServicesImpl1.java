package edu.eci.cosw.sharepark.services;

import edu.eci.cosw.sharepark.entities.User;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;

/**
 * Created by Andrés Felipe on 12/09/2016.
 */
@Service
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

    @Override
    public void updateUser(User u) {
        for (User user : users) {
            if(user.getId()==u.getId()){
                user=u;
                break;
            }
        }
    }
}
