package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Comment;
import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import com.mohbaba.api.data.repositories.CommentRepository;
import com.mohbaba.api.dto.requests.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mohbaba.api.utils.Mapper.map;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;
    @Override
    public Post addComment(CommentRequest commentRequest, User user) {
        Post post = postService.findPost(commentRequest.getPostId());
        Comment comment = map(commentRequest, user);
        Comment savedComment = commentRepository.save(comment);

        List<Comment> postComments = post.getComments();
        postComments.add(savedComment);
        post.setComments(postComments);
        return post;
    }




    @Override
    public long count() {
        return commentRepository.count();
    }


}
