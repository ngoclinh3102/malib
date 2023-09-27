package logixtek.moitech.malib.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String isbn;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 120)
    private String author;

    @Column(length = 120)
    private String publisher;

    @Column(nullable = false)
    private Integer numOfPages = 0;
}
