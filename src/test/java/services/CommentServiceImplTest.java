package services;

import exceptions.CommentAlreadyExistException;
import exceptions.CommentNotFoundException;
import models.Comment;
import models.Post;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.CommentRepository;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest {
    CommentService commentService;
    @BeforeEach
    void setUp() {
         commentService = new CommentServiceImpl();
    }

    @Test
    void testThatCommentCanBeAdded(){
        Comment comment = new Comment("love letter",new User());
        try {
            commentService.addComment(comment);
            assertEquals(1,comment.getId());
        } catch (CommentAlreadyExistException e) {
            e.getLocalizedMessage();
        }


    }

    @Test
    void testThatCommentCanBeFoundById(){
        Comment comment = new Comment("love letter",new User());
        try {
            commentService.addComment(comment);
            assertEquals(1,comment.getId());
        } catch (CommentAlreadyExistException e) {
            e.getLocalizedMessage();
        }
        try {
            Comment foundComment = commentService.findCommentById(1);
            assertEquals(1,foundComment.getId());
        } catch (CommentNotFoundException e) {
            e.getLocalizedMessage();
        }
        System.out.println(comment.getId());
        assertEquals(1,comment.getId());

    }
    @Test
    void testThatCommentCanBeUpdated(){
        Comment comment = new Comment("love letter",new User());
        try {
            commentService.addComment(comment);
            assertEquals(1,comment.getId());
        } catch (CommentAlreadyExistException e) {
            e.getLocalizedMessage();
        }
        Comment update = new Comment();
        update.setContent("nice one");

        try {
            comment = commentService.findCommentById(1);
            assertEquals("nice one",comment.getContent());
            commentService.updateComment(update,1);
        } catch (CommentNotFoundException e) {
            e.getLocalizedMessage();
        }



    }
    @Test
    void testThatCommentCanBeDeleted(){
        Comment comment = new Comment("love letter",new User());
        try {
            commentService.addComment(comment);
            assertEquals(1,comment.getId());
        } catch (CommentAlreadyExistException e) {
            e.getLocalizedMessage();
        }
        try {
            commentService.deleteComment(1);
            assertEquals(0,commentService.count());
        } catch (CommentNotFoundException e) {
            e.getLocalizedMessage();
        }



    }


}