package services;


import exceptions.CommentAlreadyExistException;
import exceptions.CommentNotFoundException;
import models.Comment;

public interface CommentService {
    String addComment(Comment comment) throws CommentAlreadyExistException;
    Comment updateComment(Comment comment,int id) throws CommentNotFoundException;
    Comment findCommentById(int id) throws CommentNotFoundException;
    String deleteComment(int id) throws CommentNotFoundException;

    int count();
}
