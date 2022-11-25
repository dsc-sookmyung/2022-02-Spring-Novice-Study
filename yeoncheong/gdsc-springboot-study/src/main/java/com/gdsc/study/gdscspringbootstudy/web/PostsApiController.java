package com.gdsc.study.gdscspringbootstudy.web;

import com.gdsc.study.gdscspringbootstudy.service.posts.PostsService;
import com.gdsc.study.gdscspringbootstudy.web.dto.PostsListResponseDto;
import com.gdsc.study.gdscspringbootstudy.web.dto.PostsResponseDto;
import com.gdsc.study.gdscspringbootstudy.web.dto.PostsSaveRequestDto;
import com.gdsc.study.gdscspringbootstudy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping
    public List<PostsListResponseDto> getPostsList(){
        return postsService.findAllDesc();
    }
}
