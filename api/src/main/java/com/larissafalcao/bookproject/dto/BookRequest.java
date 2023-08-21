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
public class BookRequest {
    private String name;
    private Integer edition;
    private String editora;
    private String isbn;
    private String language;
    private Long categoryId;
    private List<String> authorsName;
}
