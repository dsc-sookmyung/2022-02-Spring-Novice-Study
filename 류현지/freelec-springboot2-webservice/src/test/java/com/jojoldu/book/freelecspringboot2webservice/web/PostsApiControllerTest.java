package com.jojoldu.book.freelecspringboot2webservice.web;


import com.jojoldu.book.freelecspringboot2webservice.domain.posts.PostRepository;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;

import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
//JPA 기능까지 한번에 테스트
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //랜덤포트 실행
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void tearDown() throws Exception {
        postRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        //1. given
        String title = "title";
        String content = "content";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();
        //임의로 저장할 data 담은 dto 객체 생성
        String url = "http://localhost:"+port+"/api/v1/posts";

        //2. when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //3. then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK); //response 엔티티의 상태가 OK라면
        assertThat(responseEntity.getBody()).isGreaterThan(0L); //body가 존재한다면

        //Repository 모든 객체 불러와 리스트 all에 저장 (사실상 위에서 저장한 1개)
        List<Posts> all = postRepository.findAll();
        //첫 번재 객체의 제목과 내용 같은지 비교-> 같으면 pass
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);

    }

    @Test
    public void Posts_수정된다() throws Exception {
        //1. given
        Posts savePosts = postRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //Repository에 테스트용 객체 생성 후 save한 뒤 해당 엔티티 -> savePosts로 저장

        Long updateId = savePosts.getId(); //test할 엔티티 id 가져와 저장
        //수정할 값 (결과와 비교할 값)
        String expectedTitle = "title2";
        String expectedContent = "content2";

        //수정할 data Dto로 저장
        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;
        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //2. when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT
                ,requestEntity, Long.class); //title, content 변경 값으로 업데이트

        //3. then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);

    }
}
