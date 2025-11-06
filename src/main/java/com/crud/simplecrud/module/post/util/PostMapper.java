package com.crud.simplecrud.module.post.util;

import com.crud.simplecrud.module.post.persistence.PostModel;
import com.crud.simplecrud.module.post.domain.Post;
import com.crud.simplecrud.shared.domain.PostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostModel toModel(Post domain);
    PostDTO toDto(PostModel model);
    Post toDomain(PostModel model);
}
