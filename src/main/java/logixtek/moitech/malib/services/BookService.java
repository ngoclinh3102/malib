package logixtek.moitech.malib.services;

import logixtek.moitech.malib.entities.Book;
import logixtek.moitech.malib.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Cacheable("books")
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }
}
