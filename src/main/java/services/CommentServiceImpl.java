package services;

import exceptions.CommentAlreadyExistException;
import exceptions.CommentNotFoundException;
import models.Comment;
import repositories.CommentRepository;

public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository = new CommentRepository();

    @Override
    public String addComment(Comment comment) throws CommentAlreadyExistException {
        Comment comment1 = commentRepository.findCommentById(comment.getId());
        if(comment1 != null){
            throw new CommentAlreadyExistException("Comment Already Exist");
        }
        return "Comment Added Sucessfully";
    }

    @Override
    public Comment updateComment(Comment comment,int id) throws CommentNotFoundException {
       Comment comment1 = findCommentById(id);
       if(comment1.getContent() == null){
           comment1.setContent(comment.getContent());

       }

        return comment1;
    }

    @Override
    public Comment findCommentById(int id) throws CommentNotFoundException {
        Comment comment1 = commentRepository.findCommentById(id);
        if(comment1 == null){
            throw new CommentNotFoundException("Post Does not Exist");


        }
        return comment1;
    }

    @Override
    public String deleteComment(int id) throws CommentNotFoundException {
        Comment comment = commentRepository.findCommentById(id);
        if(comment == null){
            throw  new CommentNotFoundException("Comment does not exist");
        }
        commentRepository.delete(comment);
        return "Comment deleted";
    }

    @Override
    public int count() {
        return commentRepository.count();
    }
}
