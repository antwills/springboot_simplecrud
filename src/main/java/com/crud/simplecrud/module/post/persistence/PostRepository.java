package com.crud.simplecrud.module.post.persistence;

import com.crud.simplecrud.module.post.domain.Post;
import com.crud.simplecrud.shared.domain.PostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long> {


    @Query("SELECT new com.crud.simplecrud.shared.domain.PostDTO(p.id, p.content, p.createdAt, p.userId) "
            + "FROM PostModel p WHERE p.userId = :userId")
    List<PostDTO> findByUserId(@Param("userId") Long userId);
}
