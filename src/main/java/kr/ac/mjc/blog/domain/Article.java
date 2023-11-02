package kr.ac.mjc.blog.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id; //멤버변수


    @Column(name = "title", nullable = false) // mysql과 연동 되게끔 만들어줌 null이 될수 업게 만들어준다.
    private String title; //멤버변수

    @Column(name = "content",nullable = false) //마찬가지로 null이 될 수 없게 만들어준다.
    private String content; //멤버변수

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateAt;

    @Builder
    public Article(String title,String content){
        this.title = title; //지역변수
        this.content = content; //지역변수
    } //생성자 사용을 통해 title안에 title을 정의, content안에 content를 정의

    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }

    public String getFormattedCreateDate(){
        if(createdAt==null){
            return "";

        }
        DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createdAt.format(pattern);
    }
}
