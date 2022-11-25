package com.jojoldu.book.springboot.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.posts.Posts;
import org.example.springboot.web.dto.PostSaveRequestDto;
@Getter
@NoArgsConstructor

public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }
}