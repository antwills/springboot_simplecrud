package com.crud.simplecrud.module.composition.web;

import com.crud.simplecrud.module.post.application.PostService;
import com.crud.simplecrud.module.user.application.UserService;
import com.crud.simplecrud.shared.domain.PostDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserProfileController {
    private final UserService userService;
    private final PostService postService;

    public UserProfileController(UserService userService, PostService postService){
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/{userId}/posts")
    public List<PostDTO> getAllPosts(@PathVariable Long userId){
        if(userService.getById(userId).isEmpty())
            return List.of();
        return postService.getByUserId(userId);
    }
}
