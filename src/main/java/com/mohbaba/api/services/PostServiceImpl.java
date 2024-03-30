package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import com.mohbaba.api.data.repositories.PostRepository;
import com.mohbaba.api.data.repositories.UserRepository;
import com.mohbaba.api.exceptions.AccountNotFoundException;
import com.mohbaba.api.exceptions.EmptyPostException;
import com.mohbaba.api.exceptions.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addPost(User user, Post post) {
        validate(user,post);
        validate(post.getTitle(),post.getContent());
        postRepository.save(post);
        save(user, post);
    }

    private void save(User user, Post post) {
        List<Post> userPosts = user.getPosts();
        userPosts.add(post);
        user.setPosts(userPosts);
        userRepository.save(user);
    }

    private void validate(User user, Post post){
        if (user == null)throw new AccountNotFoundException("Account doesn't exist");
        if (post == null)throw new EmptyPostException("Post is Empty");
    }

    private void validate(String title, String body){
        if (title == null)throw new EmptyPostException("Title is empty");
        if (body == null)throw new EmptyPostException("Body is empty");
    }

    @Override
    public long getPostCount() {
        return postRepository.count();
    }

    @Override
    public Post findPost(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty())throw new PostNotFoundException("The post you're looking for doesn't " +
                "exist");
        return post.get();
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post findPostBy(String username) {

        return null;
    }

//    @Override
//    public List<Post> findPostsByUsername(String username) {
//        return null;
//    }
}
