package com.example.rdSeminar.repository;

import com.example.rdSeminar.domain.Member;
import com.example.rdSeminar.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

    static List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);
}
