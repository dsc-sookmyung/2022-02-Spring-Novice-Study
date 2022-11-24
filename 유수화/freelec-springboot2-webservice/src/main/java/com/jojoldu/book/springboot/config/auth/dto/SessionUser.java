package com.jojoldu.book.springboot.config.auth.dto;
import com.jojoldu.book.springboot.domain.user.User;

import lombok.Getter;

import java.io.Serializable;

// 인증된 사용자 정보만 필요하므로 name, email, picture만 필요
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}