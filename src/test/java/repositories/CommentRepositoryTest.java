package repositories;

import models.Comment;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryTest {
    CommentRepository commentRepository;
    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepository();
    }

    @Test
    void testThatCommentCanBeSaved(){
        Comment comment = new Comment("Nice post",new User());
        commentRepository.add(comment);
        assertEquals(1,commentRepository.count());
    }
    @Test
    void testThatCommentCanBDeleted() {
        Comment comment = new Comment("Nice post", new User());
        commentRepository.add(comment);
        commentRepository.add(comment);
        assertEquals(2, commentRepository.count());
        commentRepository.delete(comment);
        assertEquals(1,commentRepository.count());
    }
    @Test
    void testThatCommentCanBeDeletedById(){
        Comment comment = new Comment("Nice post", new User());
        commentRepository.add(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.delete(1);
        assertEquals(0,commentRepository.count());
        //todo complete this task;

    }
    @Test
    void testThatCommentCanBeFoundById(){
        Comment comment = new Comment("Nice post", new User());
        commentRepository.add(comment);
        commentRepository.add(comment);
        assertEquals(2, commentRepository.count());
       commentRepository.findCommentById(1);
    }


}



