package com.jojoldu.book.freelecspringboot2webservice.web.domain.posts;


import com.jojoldu.book.freelecspringboot2webservice.domain.posts.PostRepository;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @AfterEach
    public void cleanup() {
        postRepository.deleteAll(); //test 수행 시 마다 db 초기화
    }

    @Test
    public void 게시글저장_불러오기() {
        //1. given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //2. when
        List<Posts> postsList = postRepository.findAll();

        //3. then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
