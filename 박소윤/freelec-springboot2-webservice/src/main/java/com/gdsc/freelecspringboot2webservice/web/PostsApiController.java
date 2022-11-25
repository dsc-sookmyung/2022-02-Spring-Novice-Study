package com.gdsc.freelecspringboot2webservice.web;

import com.gdsc.freelecspringboot2webservice.domain.posts.Posts;
import com.gdsc.freelecspringboot2webservice.domain.posts.PostsRepository;
import com.gdsc.freelecspringboot2webservice.service.posts.PostsService;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsResponseDto;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {
    private final PostsService postsService;
    private final PostsRepository postsRepository;

    @PostMapping
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @GetMapping
    public List<Posts> getCourses(){
        return postsRepository.findAllDesc();
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
