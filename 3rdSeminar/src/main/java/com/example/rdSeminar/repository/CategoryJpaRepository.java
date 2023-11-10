package com.example.rdSeminar.repository;

import com.example.rdSeminar.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {
}
