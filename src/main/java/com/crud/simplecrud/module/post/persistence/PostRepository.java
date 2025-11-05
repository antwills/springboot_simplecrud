package com.crud.simplecrud.module.post.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Long> {
}
