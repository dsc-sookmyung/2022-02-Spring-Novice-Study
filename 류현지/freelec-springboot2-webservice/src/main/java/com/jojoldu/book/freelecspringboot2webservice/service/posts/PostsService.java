package com.jojoldu.book.freelecspringboot2webservice.service.posts;


import com.jojoldu.book.freelecspringboot2webservice.domain.posts.PostRepository;
import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsResponseDto;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postRepository.findById(id) //수정할 객체 id로 찾아서
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        //requestDto 내용으로 title, content 수정
        posts.update(requestDto.getTitle(), requestDto.getContent());

        //해당 data id 반환
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        //찾은 엔티티 data Dto에 담아 반환 (view에 뿌릴거니까 Dto)
        return new PostsResponseDto(entity);
    }
}
