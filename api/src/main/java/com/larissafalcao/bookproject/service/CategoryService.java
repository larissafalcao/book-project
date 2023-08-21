package com.larissafalcao.bookproject.service;

import com.larissafalcao.bookproject.domain.Book;
import com.larissafalcao.bookproject.domain.Category;
import com.larissafalcao.bookproject.mapper.BookMapper;
import com.larissafalcao.bookproject.repository.AuthorRepository;
import com.larissafalcao.bookproject.repository.BookRepository;
import com.larissafalcao.bookproject.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAll(){
        log.info("CategoryService: beginning getAll method");
        return categoryRepository.findAll();
    }
}
