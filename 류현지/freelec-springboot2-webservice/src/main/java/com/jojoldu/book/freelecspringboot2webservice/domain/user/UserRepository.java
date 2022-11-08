package com.jojoldu.book.freelecspringboot2webservice.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //소셜 로그인에서 중복 사용자 체크할 때, 이메일로 생성된 사용자인지 체크하는 메소드
    Optional<User> findByEmail(String email);
}
