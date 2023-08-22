package com.larissafalcao.bookproject.controller;

import com.larissafalcao.bookproject.domain.Book;
import com.larissafalcao.bookproject.dto.BookDTO;
import com.larissafalcao.bookproject.dto.BookRequest;
import com.larissafalcao.bookproject.mapper.BookMapper;
import com.larissafalcao.bookproject.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Log4j2
@CrossOrigin(origins = "http://127.0.0.1:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController implements BookOpenApi{

    private final BookService service;
    private final BookMapper bookMapper;

    @PostMapping("/new")
    public ResponseEntity<String> saveBook(@RequestBody BookRequest bookRequest) {
        log.info("controller: beginning saveBook method");
        Optional<Book> book = service.newBook(bookRequest);

        return book.map(value -> new ResponseEntity<>("Seu livro de nome " + value.getName() + " foi salvo",
                HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>("Houve um problema ao salvar sua solicitação",
                HttpStatus.BAD_REQUEST));
    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        log.info("controller: beginning getAllBooks method");
        List<BookDTO> bookDTOList = new ArrayList<>();

        List<Book> books = service.getAll();
        if(books.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for (Book book: books) {
            bookDTOList.add(bookMapper.convertToDto(book));
        }

        return new ResponseEntity<>(bookDTOList, HttpStatus.OK);
    }
}
