package services;

import exceptions.BadCredentialsException;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import models.User;
import repositories.UserRepository;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl() {

        userRepository = new UserRepository();
    }

    @Override
    public String register(User user) throws UserAlreadyExistException {
        User user1 = userRepository.findUserByEmail(user.getEmail());
        if (user1 != null) {
            throw new UserAlreadyExistException("This user already exists");
        }
        userRepository.save(user);
        return "Successfully Registered";
    }

    @Override
    public User logIn(String passWord, String eMail) throws UserNotFoundException, BadCredentialsException{
        User user1 = userRepository.findUserByEmail(eMail);
        if(user1 == null){
            throw new UserNotFoundException("This email does not exist");
        }
        if(user1.getPassWord().equals(passWord)){
            return user1;
        }

        throw  new BadCredentialsException("Wrong Password");
    }

    @Override
    public User findUser(int id) throws UserNotFoundException {
        User user1 = userRepository.findUserById(id);
        if (user1 == null){
            throw new UserNotFoundException("User not found");
        }
        return user1;

    }

    @Override
    public User findUser(String eMail) throws  UserNotFoundException {
        User user1 = userRepository.findUserByEmail(eMail);
        if (user1 == null){
            throw new UserNotFoundException("User not found");
        }
        return user1;

    }

    @Override
    public User updateUser(User user,int id) throws UserNotFoundException {
        User user1 = findUser(id);
        if(user.getFirstName() != null){
            user1.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null){
            user1.setLastName(user.getLastName());
        }
        if(user.getEmail() != null){
            user1.setEmail(user.getEmail());
        }

        return user1;
    }

    @Override
    public String deleteUser(int id) {
        userRepository.delete(id);

        return "User has been deleted successfully";
    }

    @Override
    public int count() {
        return userRepository.count();
    }

}
