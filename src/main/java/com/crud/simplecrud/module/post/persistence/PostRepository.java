package com.crud.simplecrud.module.post.persistence;

import com.crud.simplecrud.module.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long> {


    @Query("SELECT p FROM PostModel p WHERE p.userId = :userId")
    List<PostModel> findByUserId(@Param("userId") Long userId);
}
