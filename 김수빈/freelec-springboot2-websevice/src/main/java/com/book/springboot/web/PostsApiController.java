package com.book.springboot.web;

import com.book.springboot.web.dto.PostsSaveRequestDto;
import com.book.springboot.service.posts.PostsService;
import com.book.springboot.web.dto.PostsResponseDto;
import com.book.springboot.web.dto.PostsUpdateRequestDto; //

import com.book.springboot.web.dto.PostsListResponseDto; //
import java.util.List; //

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    //목록 얻어오기
    @GetMapping("/api/v1/posts/")
    public List<PostsListResponseDto> getPostsList(){
        return postsService.findAllDesc();
    }

}
