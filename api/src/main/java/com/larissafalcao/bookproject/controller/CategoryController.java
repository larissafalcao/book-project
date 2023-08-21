package com.larissafalcao.bookproject.controller;

import com.larissafalcao.bookproject.domain.Category;
import com.larissafalcao.bookproject.dto.CategoryDTO;
import com.larissafalcao.bookproject.mapper.CategoryMapper;
import com.larissafalcao.bookproject.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/api/category")
public class CategoryController implements CategoryOpenApi{
    private final CategoryService service;
    private final CategoryMapper categoryMapper;
    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        log.info("controller: beginning CategoryController method");
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        List<Category> categories = service.getAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for (Category category: categories) {
            categoryDTOList.add(categoryMapper.convertToDto(category));
        }

        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }
}
