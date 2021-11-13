package services;

import models.Comment;
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
        commentService.addComment(comment);


    }

}