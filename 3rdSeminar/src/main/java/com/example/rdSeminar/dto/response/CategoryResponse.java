package com.example.rdSeminar.dto.response;

import com.example.rdSeminar.domain.Category;
import com.example.rdSeminar.domain.Post;

public record CategoryResponse(
        Short categoryId
) {
    public static CategoryResponse of(Category category) {
        return new CategoryResponse(
                category.getId()
        );
    }
}

