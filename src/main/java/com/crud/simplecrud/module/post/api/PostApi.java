package com.crud.simplecrud.module.post.api;

import com.crud.simplecrud.module.post.application.PostService;
import com.crud.simplecrud.shared.domain.PostDTO;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PostApi {
    public List<PostDTO> getByUserId(Long userId);
}
