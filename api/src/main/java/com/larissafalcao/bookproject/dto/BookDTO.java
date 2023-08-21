package com.larissafalcao.bookproject.dto;

import com.larissafalcao.bookproject.domain.Author;
import com.larissafalcao.bookproject.domain.Category;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String name;
    private Integer edition;
    private String editora;
    private String isbn;
    private String language;
    private Category category;
    private List<Author> authors;
}
