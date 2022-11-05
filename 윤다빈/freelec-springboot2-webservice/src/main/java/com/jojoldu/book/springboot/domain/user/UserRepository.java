package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// User의 CRUD를 책임질 것
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    // findByEmail : 소셜 로그인으로 반환되는 값 중 이메일을 통해 처음 가입인지 아닌지 판단하기 위한 메소드
}