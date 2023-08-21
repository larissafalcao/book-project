package com.larissafalcao.bookproject.service;

import com.larissafalcao.bookproject.domain.Book;
import com.larissafalcao.bookproject.dto.BookRequest;
import com.larissafalcao.bookproject.mapper.BookMapper;
import com.larissafalcao.bookproject.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper mapper;

    public List<Book> getAll(){
        log.info("service: beginning getAll method");
        return bookRepository.findAll();
    }

    public Optional<Book> newBook(BookRequest bookRequest){
        log.info("service: beginning newBook method");
        try{
            Book book = mapper.convertToEntity(bookRequest);
            return Optional.of(bookRepository.save(book));
        }catch (Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
}
