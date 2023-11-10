package com.example.rdSeminar.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<Post> posts = new ArrayList<>();

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private int age;

    @Embedded
    private Sopt sopt;

    @Builder
    public Member(String name, String nickname, int age, Sopt sopt) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }
}