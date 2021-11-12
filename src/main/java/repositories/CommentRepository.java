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

    public void remove(Comment comment) {
        comments.remove(comment);
    }
}
