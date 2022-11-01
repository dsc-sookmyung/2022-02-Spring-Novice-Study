package com.gdsc.freelecspringboot2webservice.service.posts;

import com.gdsc.freelecspringboot2webservice.domain.posts.Posts;
import com.gdsc.freelecspringboot2webservice.domain.posts.PostsRepository;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsListResponseDto;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsResponseDto;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.gdsc.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
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
        Posts posts=postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id)
        );
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly=true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) //postsRepository결과로 넘어온 Posts의 Stream을 map을 통해 PostsResponseDto 변환, List 변환
                .collect(Collectors.toList());
    }

    public PostsResponseDto findById(Long id){
        Posts entity =postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id)
        );

        return new PostsResponseDto(entity);
    }

    @Transactional
    public void delete(Long id){
        Posts posts=postsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id)
        );
        postsRepository.delete(posts);
    }

}
