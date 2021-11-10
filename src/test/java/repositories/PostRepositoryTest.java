package repositories;

import models.Post;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {
    PostRepository postRepository;
    @BeforeEach
    void setUp() {
        postRepository = new PostRepository();
    }

    @Test
    void testThatPostCanBeCreated(){
        Post post1 = new Post("PC","My first Secondary School",new User());
        postRepository.save(post1);
        assertEquals(1,postRepository.count());


    }
    @Test
    void testThatPostCanBeDeleted(){
        Post post1 = new Post("PC","My first Secondary School",new User());
        postRepository.save(post1);
        assertEquals(1,postRepository.count());
        postRepository.delete(post1);
        assertEquals(0,postRepository.count());

    }
    @Test
    void testThatPostCanBeDeletedById(){
        Post post1 = new Post("PC","My first Secondary School",new User());
        postRepository.save(post1);
        assertEquals(1,postRepository.count());
        postRepository.delete(1);
        assertEquals(0,postRepository.count());
    }

    @Test
    void testThatPostCanBeFoundById(){
        Post post1 = new Post("PC","My first Secondary School",new User());
        postRepository.save(post1);
        assertEquals(1,postRepository.count());
        Post foundPost = null;
        foundPost = postRepository.findPostById(1);
        assertEquals("PC",foundPost.getTitle());


    }
}