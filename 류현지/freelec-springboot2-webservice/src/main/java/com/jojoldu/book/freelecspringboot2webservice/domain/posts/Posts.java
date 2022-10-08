package com.jojoldu.book.freelecspringboot2webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//*어노테이션 순서 - 주요 어노테이션을 클래스와 가깝게

@Getter //lombok
@NoArgsConstructor //lombok
@Entity //<< 주요 어노테이션
public class Posts {  //실제 DB table과 매칭 될 클래스 == Entity 클래스
    //id 정의
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
