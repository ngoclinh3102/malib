package logixtek.moitech.malib.controllers;

import jakarta.validation.Valid;
import logixtek.moitech.malib.configurations.versioning.ApiVersion;
import logixtek.moitech.malib.models.BookDto;
import logixtek.moitech.malib.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ApiVersion({1})
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<?> getBookList() {
        return ResponseEntity.ok(bookService.getBookList());
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody @Valid BookDto book) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Add Successfully: " + book.getName());
    }
}
