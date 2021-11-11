package services;

import exceptions.PostAlreadyExistException;
import exceptions.PostNotFoundException;
import models.Post;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
    PostService postService;

    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
    }

    @Test
    void testThatPostCanBeAdded() {
        Post post1 = new Post("Pc", "First secondary school", new User());
        try {
            postService.addPost(post1);
            assertEquals(1, post1.getId());
        } catch (PostAlreadyExistException e) {
            e.getLocalizedMessage();
        }


    }

    @Test
    void testThatPostCanBeFoundById() {
        Post post1 = new Post("PC", "First secondary school", new User());
        try {
            postService.addPost(post1);
            assertEquals(1, post1.getId());
        } catch (PostAlreadyExistException e) {
            e.getLocalizedMessage();
        }

        try {
            Post foundPost = postService.findPostById(1);
            assertEquals(1, foundPost.getId());
        } catch (PostNotFoundException e) {
            System.out.println(123);
            System.out.println(e.getLocalizedMessage());
        }


    }

    @Test
    void testThatPostCanBeUpdated() {
        Post post1 = new Post("Pc", "First secondary school", new User());
        try {
            postService.addPost(post1);
            assertEquals(1, post1.getId());
        } catch (PostAlreadyExistException e) {
            e.getLocalizedMessage();
        }
        Post update = new Post();
        update.setTitle("Peaklane");

        try {
            postService.updatePost(update, 1);
            post1 = postService.findPostById(1);
            System.out.println(post1);
            assertEquals(1, post1.getId());
        } catch (PostNotFoundException e) {
            e.getLocalizedMessage();
            System.out.println(e.getMessage());
        }


    }
    @Test
    void testThatPostCanBeDeleted(){
        Post post1 = new Post("Pc", "First secondary school", new User());
        try {
            postService.addPost(post1);
            assertEquals(1, post1.getId());
        } catch (PostAlreadyExistException e) {
            e.getLocalizedMessage();
        }


    }

}