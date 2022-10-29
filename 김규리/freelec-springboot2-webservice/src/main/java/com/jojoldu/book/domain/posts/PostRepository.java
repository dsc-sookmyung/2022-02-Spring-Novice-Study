package com.jojoldu.book.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Long> {

    @Query ("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
