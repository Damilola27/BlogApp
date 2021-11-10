package services;

import exceptions.PostAlreadyExistException;
import exceptions.PostNotFoundException;
import models.Post;

public interface PostService {
    String addPost(Post post) throws PostAlreadyExistException;
    String updatePost();
    Post findPostById(int id) throws PostNotFoundException;
    String deletePost();





}
