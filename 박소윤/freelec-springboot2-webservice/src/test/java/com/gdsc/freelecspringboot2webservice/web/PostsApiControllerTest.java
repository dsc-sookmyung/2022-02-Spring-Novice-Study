package com.gdsc.freelecspringboot2webservice.web;

import com.gdsc.freelecspringboot2webservice.domain.posts.Posts;
import com.gdsc.freelecspringboot2webservice.domain.posts.PostsRepository;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception{
        //given
        String title="title";
        String content="content";
        PostsSaveRequestDto requestDto= PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url="http://localhost:"+port+"/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity=restTemplate.postForEntity(url,requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all=postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    public void Posts_수정된다() throws Exception{
        //given
        Posts savedPosts=postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        Long updateId=savedPosts.getId();
        String exceptedTitle="title2";
        String exceptedContent="content2";

        PostsUpdateRequestDto requestDto=PostsUpdateRequestDto.builder()
                .title(exceptedTitle)
                .content(exceptedContent)
                .build();

        String url="http://localhost:"+port+"/api/v1/posts/"+updateId;
        HttpEntity<PostsUpdateRequestDto> requestEntity=new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity=restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all =postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(exceptedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(exceptedContent);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now=LocalDateTime.of(2022,10,7,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts=postsList.get(0);

        System.out.println(">>>>>>>> created Date="+posts.getCreatedDate()+", modified Date="+posts.getModifiedDate());
        assertThat(posts.getCreatedDate().isAfter(now));
        assertThat(posts.getModifiedDate().isAfter(now));
    }
}
