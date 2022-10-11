package com.jojoldu.book.springboot.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor

// JPA 에서 제공하는 어노테이션
// 테이블과 링크될 클래스
@Entity
public class Posts extends BaseTimeEntity {
    // 해당 테이블의 PK 필드를 나타낸다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 테이블의 칼럼을 나타내고 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content,String author ){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}