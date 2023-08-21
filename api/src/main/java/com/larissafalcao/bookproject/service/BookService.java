package com.larissafalcao.bookproject.service;

import com.larissafalcao.bookproject.domain.Author;
import com.larissafalcao.bookproject.domain.Book;
import com.larissafalcao.bookproject.dto.BookRequest;
import com.larissafalcao.bookproject.mapper.BookMapper;
import com.larissafalcao.bookproject.repository.AuthorRepository;
import com.larissafalcao.bookproject.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper mapper;

    public List<Book> getAll(){
        log.info("BookService: beginning getAll method");
        return bookRepository.findAll();
    }

    public Optional<Book> newBook(BookRequest bookRequest){
        log.info("BookService: beginning newBook method");
        try{
            Book book = mapper.convertToEntity(bookRequest);
            List<Author> authors = new ArrayList<>();
            for (String authorName: bookRequest.getAuthorsName()) {
                Author author = Author.builder().name(authorName).build();
                authors.add(author);
            }
            List<Author> authorsSaved = authorRepository.saveAll(authors);
            book.setAuthors(authorsSaved);

            return Optional.of(bookRepository.save(book));
        }catch (Exception e){
            log.error(e);
            return Optional.empty();
        }
    }
}
