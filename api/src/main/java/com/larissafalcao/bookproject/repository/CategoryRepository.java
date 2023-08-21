package com.larissafalcao.bookproject.repository;

import com.larissafalcao.bookproject.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
