package com.jojoldu.book.freelecspringboot2webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Long> {

    //SpringDataJpa에서 제공하는 기본 메소드만으로 해결 가능
    @Query("SELECT p FROM Posts p order by p.id DESC")
    List<Posts> findAllDesc();
}
