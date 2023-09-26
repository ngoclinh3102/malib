package logixtek.moitech.malib.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String name;

    private String author;

    private String publisher;
}
