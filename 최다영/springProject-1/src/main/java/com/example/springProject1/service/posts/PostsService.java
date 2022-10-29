package com.example.springProject1.service.posts;


import java.util.List;
import java.util.stream.Collectors;

import com.example.springProject1.domain.posts.Posts;
import com.example.springProject1.domain.posts.PostsRepository;
import com.example.springProject1.web.dto.PostsListResponseDto;

import com.example.springProject1.web.dto.PostsResponseDto;
import com.example.springProject1.web.dto.PostsSaveRequestDto;
import com.example.springProject1.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

<<<<<<< HEAD
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

=======
>>>>>>> origin/main
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
<<<<<<< HEAD

=======
>>>>>>> origin/main
}
