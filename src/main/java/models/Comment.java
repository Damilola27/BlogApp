package models;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public class Comment {
    private int id;
    private String content;
    private User author;
    private LocalDate dateCreated;
    private LocalTime time;
    private static int idGenerator;


    public Comment(String content, User author) {
        this.content = content;
        this.author = author;
        dateCreated =LocalDate.now();
        time = LocalTime.now();
        idGenerator++;
        id = idGenerator;
    }

    public Comment() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
