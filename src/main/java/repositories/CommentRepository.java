package repositories;

import models.Comment;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {

    List <Comment> comments = new ArrayList<>();

    public void add(Comment comment) {
        comments.add(comment);
    }

    public int count() {
        return comments.size();
    }

    public void delete(Comment comment) {
        comments.remove(comment);
    }

    public Comment findCommentById(int id) {
        for(Comment comment: comments){
            if(comment.getId() == id){
                return comment;
            }
        }
        return  null;
    }

    public void delete(int id) {
        for(Comment comment: comments){
            if(comment.getId() ==id){
                comments.remove(comment);
                break;
            }
        }
    }
}
