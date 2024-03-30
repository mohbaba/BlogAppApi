package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import com.mohbaba.api.data.models.View;
import com.mohbaba.api.data.repositories.UserRepository;
import com.mohbaba.api.dto.requests.PostRequest;
import com.mohbaba.api.dto.requests.RegisterUserRequest;
import com.mohbaba.api.dto.requests.ViewRequest;
import com.mohbaba.api.dto.responses.RegisterUserResponse;
import com.mohbaba.api.exceptions.UsernameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mohbaba.api.utils.Mapper.map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostService postService;
    @Autowired
    private ViewService viewService;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        validate(registerUserRequest.getUsername());
        User user = map(registerUserRequest);
        RegisterUserResponse response = map(user);
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
    public long getNumberOfViews(PostRequest postRequest) {
        Post post = postService.findPostBy(postRequest.getUsername());

        return post.getViews().size();
    }

    @Override
    public void view(ViewRequest viewRequest) {
        User user = userRepository.findByUsername(viewRequest.getViewerUsername());
        View view = new View();
        view.setViewer(user);

        Post post = postService.findPost(viewRequest.getPostId());
        List<View> postViews = post.getViews();
        postViews.add(view);
        post.setViews(postViews);
        postService.save(post);
        viewService.addView(view);

    }
}
