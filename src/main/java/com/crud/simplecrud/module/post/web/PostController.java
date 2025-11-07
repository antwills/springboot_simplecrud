package com.crud.simplecrud.module.post.web;

import com.crud.simplecrud.module.post.application.PostService;
import com.crud.simplecrud.module.post.domain.Post;
import com.crud.simplecrud.module.post.dto.CreatePostDTO;
import com.crud.simplecrud.shared.domain.PostDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/all")
    public List<Post> getAll(){
        return this.postService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable Long id){
        return this.postService.getBydId(id);
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody CreatePostDTO dto){
        return this.postService.create(dto);
    }
}
