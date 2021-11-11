package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id;
    private String  title;
    private String description;
    private List <Comment> comments = new ArrayList<>();
    private User author;
    public static int idGenerator;
    private LocalDate dateCreated;

    public Post(String title, String description, User author) {
        this.title = title;
        this.description = description;
        this.author = author;
        dateCreated = LocalDate.now();
        idGenerator++;
        id = idGenerator;
    }

    public Post() {

    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
