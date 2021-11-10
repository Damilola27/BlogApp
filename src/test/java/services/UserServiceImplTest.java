package services;

import exceptions.BadCredentialsException;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void testThatUserCanRegister() {
        User userOne = new User("Dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        try {
            userService.register(userOne);
            assertEquals(1, userOne.getId());
        } catch (UserAlreadyExistException e) {
            e.getLocalizedMessage();
        }
    }

    @Test
    void testThatUserThatAlreadyExistCanNotRegister(){
        User userOne = new User("Dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        try {
            userService.register(userOne);
            assertEquals(1, userOne.getId());
        } catch (UserAlreadyExistException e) {
            e.getLocalizedMessage();
        }

       UserAlreadyExistException exception = assertThrows(UserAlreadyExistException.class, () -> userService.register(userOne));
        assertEquals("This user already exists", exception.getLocalizedMessage());
    }

    @Test
    void testThatUserCanLogin() {
        User user1 = new User("Dami", "Omolori", "damilolaomolori@yahoo.com", "dami");

        try {
            userService.register(user1);
            assertEquals(1, user1.getId());
        } catch (UserAlreadyExistException e) {
            e.getLocalizedMessage();
        }

        String password = "dami";
        String eMail = "damilolaomolori@yahoo.com";

        try {
            User foundUser = userService.logIn(password, eMail);
            assertEquals(user1, foundUser);
        } catch (UserNotFoundException | BadCredentialsException e) {
            e.getLocalizedMessage();
        }

    }

    @Test
    void testThatUserCanBeFoundByID() {
        User user1 = new User("Dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        try {
            userService.register(user1);
            assertEquals(1, user1.getId());
        } catch (UserAlreadyExistException e) {
            e.getLocalizedMessage();
        }
        int id = 1;
        try {
            User foundUser = userService.findUser(id);
            assertEquals(user1, foundUser);
        } catch (UserNotFoundException e) {
            e.getLocalizedMessage();
        }
    }

    @Test
    void testThatUserCanBeFoundByEmail() {
        User user1 = new User("Dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        try {
            userService.register(user1);
            assertEquals(1, user1.getId());
        } catch (UserAlreadyExistException e) {
            e.getLocalizedMessage();
        }
        String eMail = "damilolaomolori@yahoo.com";
        try {
            User foundUser = userService.findUser(eMail);
            assertEquals(user1, foundUser);
        } catch (UserNotFoundException e) {
            e.getLocalizedMessage();
        }
    }

    @Test
    void testThatUserCanBeUpdated() {
        User user1 = new User("dami", "omolori", "damilolaomolori@yahoo.com", "dami");
        try {
            userService.register(user1);
            assertEquals(1, user1.getId());
        } catch (UserAlreadyExistException e) {
            e.getLocalizedMessage();
        }
        User update = new User();
        update.setFirstName("damingo");
        update.setLastName("tosh");

        try {
            userService.updateUser(update, 1);
            user1 = userService.findUser(1);
            assertEquals("damingo", user1.getFirstName());
        } catch (UserNotFoundException e) {
            e.getLocalizedMessage();
        }

    }

    @Test
    void testThatUserCanBeDeleted() {

        //given
        User user1 = new User("dami", "omolori", "damilolaomolori@yahoo.com", "dami");
        try {
            userService.register(user1);
            assertEquals(1, user1.getId());
        } catch (UserAlreadyExistException e) {
            e.getLocalizedMessage();
        }
        //when
        userService.deleteUser(1);

        //assert
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
            userService.findUser(1);
        });

        assertEquals("User not found", exception.getLocalizedMessage());
        assertEquals(0, userService.count());

    }
}