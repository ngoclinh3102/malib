package logixtek.moitech.malib.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import logixtek.moitech.malib.entities.Book;
import logixtek.moitech.malib.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AmazonS3 amazonS3;

    public List<Book> getBookList() {
        if (!amazonS3.doesBucketExistV2("ignore-me-please")) {
            amazonS3.createBucket("ignore-me-please");
        }
        amazonS3.putObject(new PutObjectRequest("ignore-me-please","read_me_please.txt", new File("C:\\Users\\linh.vu\\Desktop\\readme.txt")));

        return bookRepository.findAll();
    }
}
