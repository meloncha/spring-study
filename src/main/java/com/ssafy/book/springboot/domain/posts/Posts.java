package com.ssafy.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스, 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
public class Posts {

    @Id /// 해당 테이블의 PK 필드를 나타낸다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙, auto increment
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼, 기본값 외에 추가로 변경이 필요한 옵션이 있는 경우 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 타입 varchar => text
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함됨 필드만 빌더에 포함
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
