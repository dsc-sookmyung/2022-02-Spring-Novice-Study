package com.gdsc.study.gdscspringbootstudy.service.posts;

import com.gdsc.study.gdscspringbootstudy.domain.posts.PostsRepository;
import com.gdsc.study.gdscspringbootstudy.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
