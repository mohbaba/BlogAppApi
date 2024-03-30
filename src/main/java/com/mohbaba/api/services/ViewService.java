package com.mohbaba.api.services;

import com.mohbaba.api.data.models.View;

public interface ViewService {
    void addView(View view);

    long getViewCount();
}
