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
        assertEquals(2,commentRepository.count());
    }
}
