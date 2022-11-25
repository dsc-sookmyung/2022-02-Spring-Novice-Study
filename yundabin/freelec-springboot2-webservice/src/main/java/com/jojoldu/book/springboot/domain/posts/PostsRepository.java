package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    // SpringDataJpa에서 제공하지 않는 메소드는 @Query로 작성해도 되고(가독성이 더 좋음) 제공하는 기본 메소드만으로도 해결 가능
    List<Posts> findAllDesc();


}
