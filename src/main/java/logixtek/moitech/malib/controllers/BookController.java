package logixtek.moitech.malib.controllers;

import logixtek.moitech.malib.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    final BookService bookService;

    @GetMapping()
    public ResponseEntity<?> getBookList() {
        return ResponseEntity.ok(bookService.getBookList());
    }
}
