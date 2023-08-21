package com.larissafalcao.bookproject.mapper;

import com.larissafalcao.bookproject.domain.Book;
import com.larissafalcao.bookproject.dto.BookDTO;
import com.larissafalcao.bookproject.dto.BookRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookMapper {
    private ModelMapper modelMapper;

    public BookDTO convertToDto(Book entity) {
        return modelMapper.map(entity, BookDTO.class);
    }

    public Book convertToEntity(BookRequest dto) {
        return modelMapper.map(dto, Book.class);
    }
}
