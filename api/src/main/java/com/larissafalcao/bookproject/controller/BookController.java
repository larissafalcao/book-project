package com.larissafalcao.bookproject.controller;

import com.larissafalcao.bookproject.domain.Book;
import com.larissafalcao.bookproject.dto.BookRequest;
import com.larissafalcao.bookproject.mapper.BookMapper;
import com.larissafalcao.bookproject.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService service;
    private final BookMapper cardMapper;

    @PostMapping("/new")
    public ResponseEntity<String> saveBook(@RequestBody BookRequest bookRequest) {
        log.info("controller: beginning saveBook method");
        Optional<Book> book = service.newBook(bookRequest);

        return !book.isEmpty() ? new ResponseEntity<>("Seu livro de nome " + book.get().getName() + " foi salvo", HttpStatus.CREATED) :
                new ResponseEntity<>("Houve um problema ao salvar sua solicitação", HttpStatus.BAD_REQUEST);
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("controller: beginning getAllBooks method");
        List<Book> result = service.getAll();

        return !result.isEmpty() ? new ResponseEntity<>(result, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
