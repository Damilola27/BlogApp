package services;

import models.Comment;
import repositories.CommentRepository;

public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository = new CommentRepository();

    @Override
    public String addComment(Comment comment) {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String findCommentById() {
        return null;
    }

    @Override
    public String deleteComment() {
        return null;
    }
}
