package com.example.rdSeminar.dto.response;

import com.example.rdSeminar.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content
) {
    public static PostGetResponse of(Post post) {
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent()
        );
    }
}
