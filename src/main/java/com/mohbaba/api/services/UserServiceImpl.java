package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import com.mohbaba.api.data.models.View;
import com.mohbaba.api.data.repositories.UserRepository;
import com.mohbaba.api.dto.requests.CommentRequest;
import com.mohbaba.api.dto.requests.PostRequest;
import com.mohbaba.api.dto.requests.RegisterUserRequest;
import com.mohbaba.api.dto.requests.ViewRequest;
import com.mohbaba.api.dto.responses.RegisterUserResponse;
import com.mohbaba.api.exceptions.UserNotFoundException;
import com.mohbaba.api.exceptions.UsernameExistsException;
import com.mohbaba.api.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mohbaba.api.utils.Mapper.map;
import static com.mohbaba.api.utils.Mapper.mapViewTo;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostService postService;
    @Autowired
    private ViewService viewService;
    @Autowired
    private CommentService commentService;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        validate(registerUserRequest.getUsername());
        User user = Mapper.map(registerUserRequest);
        RegisterUserResponse response = Mapper.map(user);
        userRepository.save(user);
        return response;
    }

    private void validate(String user){
        if (userRepository.existsByUsername(user))throw new UsernameExistsException(String.format("%s already exists",user));
    }


    @Override
    public long countNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public void post(PostRequest postRequest) {
        User user = userRepository.findByUsername(postRequest.getUsername());
        Post post = map(postRequest);
        postService.addPost(user,post);
    }
    
    @Override
    public void  view(ViewRequest viewRequest) {
        User user = userRepository.findByUsername(viewRequest.getViewerUsername());
        Post post = postService.findPost(viewRequest.getPostId());
        View view = mapViewTo(user);
        viewService.save(view);
        viewService.add(post, view);
        postService.save(post);

    }



    @Override
    public long getNumberOfPosts() {
        return postService.getPostCount();
    }

    @Override
    public int getNumberOfPosts(String username) {
        User user = userRepository.findByUsername(username);
        return user.getPosts().size();
    }

    @Override
    public long getTotalNumberOfViews() {
        return viewService.getViewCount();
    }

    @Override
    public long getNumberOfViews(ViewRequest view) {
        Post post = postService.findPost(view.getPostId());
        return post.getViews().size();
    }

    

    @Override
    public List<Post> getAllPosts() {
        return postService.findAllPosts();
    }

    @Override
    public void comment(CommentRequest commentRequest) {
        User user = userRepository.findByUsername(commentRequest.getCommenterUsername());
        Post post = commentService.addComment(commentRequest, user);
        postService.save(post);
    }




    @Override
    public long getTotalNumberOfComments() {
        return commentService.count();
    }

    @Override
    public User findUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null)throw new UserNotFoundException(String.format("%s not found",username));
        return user;
    }
}
