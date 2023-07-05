package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  //Getter와 NoArgsConstructor는 lombok의 어노테이션
@Entity //JPA의 어노테이션
public class Posts {
//실제 DB와 매칭 될 class이다. JPA에 작업할 경우, 실제 쿼리를 날리는 것이 아니라, Entity(지금은 Posts class)의 수정을 통해 정보를 날림.
//자바 정보를 SQL에 맞게 자동 매칭해주는 것이 JPA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
