package services;

import exceptions.PostAlreadyExistException;
import exceptions.PostNotFoundException;
import models.Post;
import repositories.PostRepository;

public class PostServiceImpl implements PostService{
    PostRepository postRepository;
    public PostServiceImpl() {
        postRepository = new PostRepository();
    }

    @Override
    public String addPost(Post post) throws  PostAlreadyExistException {
        Post post1 = postRepository.findPostById(post.getId());
        if (post1 != null) {
            throw new PostAlreadyExistException("Post Already exist");
        }
        return "Post added Successfully";
    }


    @Override
    public String updatePost() {


        return null;
    }

    @Override
    public Post findPostById(int id) throws  PostNotFoundException {
        Post foundPost = postRepository.findPostById(id);
        if(foundPost == null){
            throw new PostNotFoundException("Post does not exist");
        }
        return foundPost;
    }

    @Override
    public String deletePost() {
        return null;
    }
}
