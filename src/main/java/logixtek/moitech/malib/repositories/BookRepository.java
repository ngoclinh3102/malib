package logixtek.moitech.malib.repositories;

import logixtek.moitech.malib.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
