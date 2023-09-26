package logixtek.moitech.malib.services;

import logixtek.moitech.malib.entities.Book;
import logixtek.moitech.malib.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {

    final BookRepository bookRepository;

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }
}
