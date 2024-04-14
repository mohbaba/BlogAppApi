package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.View;
import com.mohbaba.api.data.repositories.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService{
    @Autowired
    private ViewRepository viewRepository;
    @Override
    public void save(View view) {
        viewRepository.save(view);
    }

    @Override
    public long getViewCount() {
        return viewRepository.count();
    }

    @Override
    public void add(Post post, View view) {
        List<View> postViews = post.getViews();
        postViews.add(view);
        post.setViews(postViews);

    }
}
