package logixtek.moitech.malib.controllers;

import logixtek.moitech.malib.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    final BookService bookService;

    @GetMapping
    public ResponseEntity<?> getBookList() {
        return ResponseEntity.ok(bookService.getBookList());
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody(required = false) String bookName) {
        return bookName != null
               ? ResponseEntity.status(HttpStatus.CREATED).body("Add Successfully: " + bookName)
               : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not empty bro");
    }
}
