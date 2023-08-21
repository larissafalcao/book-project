package com.larissafalcao.bookproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer edition;
    private String editora;
    private String isbn;
    private String language;

    @ManyToOne
    @JoinColumn(name="id_category")
    @JsonBackReference
    private Category category;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_author")
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_id"))
//    @JsonBackReference
    private List<Author> authors;
    @CreatedDate
    private LocalDateTime creationDateTime;

}
