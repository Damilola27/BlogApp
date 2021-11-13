package services;


import models.Comment;

public interface CommentService {
    String addComment(Comment comment);
    String update();
    String findCommentById();
    String deleteComment();

}
