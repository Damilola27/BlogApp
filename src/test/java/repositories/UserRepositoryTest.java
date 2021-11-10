package repositories;

import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();

    }

    @Test
    void testThatUserCanBeSaved() {
        User userOne = new User("Dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        userRepository.save(userOne);
        assertEquals(1, userRepository.count());
        User userTwo = new User("Dimeji", "Omotosho", "toshmanuel@yahoo.com", "damiiii");
        userRepository.save(userTwo);
        assertEquals(2, userRepository.count());
    }

    @Test
    void testThatUserCanBeRemoved() {
        User userOne = new User("Dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        userRepository.save(userOne);
        assertEquals(1, userRepository.count());
        User userTwo = new User("Dimeji", "Omotosho", "toshmanuel@yahoo.com", "damiiii");
        userRepository.save(userTwo);
        assertEquals(2, userRepository.count());
        userRepository.delete(userOne);
        assertEquals(1, userRepository.count());
        userRepository.delete(userTwo);
        assertEquals(0, userRepository.count());

    }

    @Test
    void testThatUsersCanBeRemovedById() {
        User userOne = new User("Dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        userRepository.save(userOne);
        assertEquals(1, userRepository.count());
        User userTwo = new User("Dimeji", "Omotosho", "toshmanuel@yahoo.com", "damiiii");
        userRepository.save(userTwo);
        assertEquals(2, userRepository.count());
        userRepository.delete(1);
        assertEquals(1, userRepository.count());

    }

    @Test
    void testThatUsersCanBeFoundById() {
        User userOne = new User("dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        userRepository.save(userOne);
        assertEquals(1, userRepository.count());
        User userTwo = new User("Dimeji", "Omotosho", "toshmanuel@yahoo.com", "damiiii");
        userRepository.save(userTwo);
        assertEquals(2, userRepository.count());
        User foundUser = null;
        foundUser = userRepository.findUserById(1);
        assertEquals("Dami".toLowerCase(), foundUser.getFirstName());


    }

    @Test
    void testThatUserCanBeFoundByEmail() {
        User userOne = new User("dami", "Omolori", "damilolaomolori@yahoo.com", "dami");
        userRepository.save(userOne);
        assertEquals(1, userRepository.count());
        User userTwo = new User("Dimeji", "Omotosho", "toshmanuel@yahoo.com", "damiiii");
        userRepository.save(userTwo);
        assertEquals(2, userRepository.count());

        User user = userRepository.findUserByEmail("damilolaOmolori@yahoo.com");
        assertEquals(1, user.getId());


    }

}

