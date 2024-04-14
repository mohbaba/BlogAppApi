package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.View;

import java.util.List;

public interface ViewService {
    void save(View view);

    long getViewCount();

    void add(Post post, View view);
}
