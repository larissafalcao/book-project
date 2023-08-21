package com.larissafalcao.bookproject.mapper;

import com.larissafalcao.bookproject.domain.Category;
import com.larissafalcao.bookproject.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryMapper {
    private ModelMapper modelMapper;

    public CategoryDTO convertToDto(Category entity) {
        return modelMapper.map(entity, CategoryDTO.class);
    }

    public Category convertToEntity(CategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }
}
