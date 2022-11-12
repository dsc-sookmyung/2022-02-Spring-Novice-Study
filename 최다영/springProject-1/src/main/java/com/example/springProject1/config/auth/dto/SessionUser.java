package com.example.springProject1.config.auth.dto;

import com.example.springProject1.domain.user.User;
import lombok.Getter;
import org.h2.engine.Session;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
