package com.crud.simplecrud.module.post.application;

import com.crud.simplecrud.module.post.api.PostApi;
import com.crud.simplecrud.module.post.persistence.PostModel;
import com.crud.simplecrud.module.post.persistence.PostRepository;
import com.crud.simplecrud.module.post.domain.Post;
import com.crud.simplecrud.module.post.dto.CreatePostDTO;
import com.crud.simplecrud.module.post.util.PostMapper;
import com.crud.simplecrud.module.user.api.UserApi;
import com.crud.simplecrud.shared.domain.PostDTO;
import com.crud.simplecrud.shared.domain.UserDTO;
import com.crud.simplecrud.shared.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements PostApi {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserApi userApi;

    @Autowired
    public PostService(PostRepository postRepository, PostMapper postMapper, UserApi userApi){
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.userApi = userApi;
    }

    public List<Post> getAll(){
        return this.postRepository
                .findAll()
                .stream()
                .map(postMapper::toDomain)
                .toList();
    }

    public Optional<Post> getBydId(Long id){
        return this.postRepository.findById(id).map(postMapper::toDomain);
    }

    public List<PostDTO> getByUserId(Long userId){
        return this.postRepository.findByUserId(userId)
                .stream()
                .map(postMapper::toDto)
                .toList();
    }

    public Post create(CreatePostDTO dto){
        UserDTO userDTO = this.userApi
                .getById(dto.userId())
                .orElseThrow(
                    () -> new NotFoundException("User not exist.")
                );

        PostModel postModel = postRepository.save(new PostModel(dto.content(), dto.userId()));

        return this.postMapper.toDomain(postModel);
    }
}
