package com.larissafalcao.bookproject.controller;

import com.larissafalcao.bookproject.domain.Book;
import com.larissafalcao.bookproject.dto.BookRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Book")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operation performed successfully."),
        @ApiResponse(responseCode = "400", description = "Bad Request: Entered parameter is invalid."),
        @ApiResponse(responseCode = "401", description = "User not Authenticated."),
        @ApiResponse(responseCode = "403", description = "User without permission."),
        @ApiResponse(responseCode = "404", description = "Resource not found."),
        @ApiResponse(responseCode = "500", description = "Internal server error.")
})
public interface BookOpenApi {
    @Operation(summary = "Get all books")
    ResponseEntity<List<Book>> getAllBooks();
    @Operation(summary = "Create book")
    ResponseEntity<String> saveBook(@RequestBody BookRequest bookRequest);
}
