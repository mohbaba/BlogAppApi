package com.mohbaba.api.services;

import com.mohbaba.api.data.models.View;
import com.mohbaba.api.data.repositories.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService{
    @Autowired
    private ViewRepository viewRepository;
    @Override
    public void addView(View view) {
        viewRepository.save(view);
    }

    @Override
    public long getViewCount() {
        return viewRepository.count();
    }
}
