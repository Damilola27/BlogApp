package services;

import exceptions.BadCredentialsException;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import models.User;

public interface UserService {
    String register(User user) throws UserAlreadyExistException;
    User logIn(String passWord, String eMail) throws UserNotFoundException, BadCredentialsException;
    User findUser(int id) throws UserNotFoundException;
    User findUser(String eMail) throws UserNotFoundException;
    User updateUser(User user,int id) throws UserNotFoundException;
    String deleteUser(int id);

    int count();
}
