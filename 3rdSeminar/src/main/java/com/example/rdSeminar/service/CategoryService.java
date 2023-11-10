package com.example.rdSeminar.service;

import com.example.rdSeminar.domain.Category;
import com.example.rdSeminar.domain.CategoryId;
import com.example.rdSeminar.dto.response.CategoryResponse;
import com.example.rdSeminar.repository.CategoryJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public Category getByCategoryId(CategoryId categoryId) { // Entity 반환
        return categoryJpaRepository.findById(Short.valueOf(categoryId.getCategoryId()))
                .orElseThrow( () -> new EntityNotFoundException("해당하는 카테고리가 없습니다."));
    }

    public CategoryResponse getById(Short id) { // DTO 반환
        return CategoryResponse.of(categoryJpaRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("해당하는 카테고리가 없습니다.")));
    }
}
