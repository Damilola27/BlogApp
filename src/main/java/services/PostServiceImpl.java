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
        postRepository.save(post);
        return "Post added Successfully";
    }


    @Override
    public Post updatePost(Post post, int id) throws PostNotFoundException {
       Post post1 = findPostById(id);
        System.out.println(post1.getId());
       if(post1.getTitle() != null){
           post1.setTitle(post.getTitle());
       }
       if(post1.getAuthor() != null){
           post1.setAuthor(post.getAuthor());
       }
       if(post1.getDescription() != null){
           post1.setDescription(post.getDescription());
       }
       return post1;
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
    public String deletePost(int id) throws PostNotFoundException {
        Post post = postRepository.findPostById(id);
        if(post == null){
            throw new PostNotFoundException("post does not exist");
        }
        postRepository.delete(post);
        return "Post has been deleted";
    }

    @Override
    public int count() {
        return postRepository.count();
    }
}
