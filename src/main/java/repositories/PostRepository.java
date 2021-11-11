package repositories;

import models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    List <Post> posts = new ArrayList<>();

    public void save(Post post) {
        posts.add(post);
    }

    public int count() {
        return posts.size();
    }

    public void delete(Post post) {
        posts.remove(post);
    }

    public void delete(int id) {
        for(Post post : posts){
            if(post.getId() == id){
                posts.remove(post);
                break;
            }
        }
    }

    public Post findPostById(int id) {
        for (Post post: posts){
            if(post.getId() == id){
                System.out.println(post.getId());
                return post;
            }
        }
        return null;
    }
}
