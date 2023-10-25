package logixtek.moitech.malib.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BookDto {

    @NotEmpty
    String isbn;

    @NotEmpty
    String name;

    @NotEmpty
    String author;

    String publisher;

    Integer numOfPages = 0;
}
