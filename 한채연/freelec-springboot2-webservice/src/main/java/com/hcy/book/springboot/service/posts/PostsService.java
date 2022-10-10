package com.hcy.book.springboot.service.posts;

import com.hcy.book.springboot.domain.posts.Posts;
import com.hcy.book.springboot.domain.posts.PostsRepository;
import com.hcy.book.springboot.web.dto.PostsListResponseDto;
import com.hcy.book.springboot.web.dto.PostsResponseDto;
import com.hcy.book.springboot.web.dto.PostsSaveRequestDto;
import com.hcy.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
              return postsRepository.findAllDesc().stream()
                      .map(PostsListResponseDto::new)  // .map(posts -> new PostsListResponseDto(posts)) 와 동일
                      .collect(Collectors.toList());  // 결과로 넘어온 Posts의 stream을 map을 통해 dto변환 -> list변환
    }
}
