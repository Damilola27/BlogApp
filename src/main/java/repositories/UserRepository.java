package repositories;

import exceptions.UserNotFoundException;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List <User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public int count() {
        return users.size();
    }

    public void delete(User user) {
        users.remove(user);
    }

    public void delete(int id){
        for(User user : users){
            if(user.getId() == id){
                System.out.println(user.toString());
                users.remove(user);
                break;
            }
        }
    }

    public User findUserById(int id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User findUserByEmail(String email) {
        for(User user : users){
            if(user.getEmail() == email){
                return user;
            }
        }
        return null;
    }
}
