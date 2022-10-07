package com.gdsc.week02.service.posts;

import com.gdsc.week02.domain.posts.Posts;
import com.gdsc.week02.domain.posts.PostsRepository;
import com.gdsc.week02.web.dto.PostsResponseDto;
import com.gdsc.week02.web.dto.PostsSaveRequestDto;
import com.gdsc.week02.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts=postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id)
        );
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity =postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id)
        );

        return new PostsResponseDto(entity);
    }
}
