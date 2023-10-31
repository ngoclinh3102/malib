package logixtek.moitech.dev.malib;

import com.amazonaws.services.s3.AmazonS3;
import logixtek.moitech.malib.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MalibApplicationTests.class)
@ComponentScan(basePackages = "logixtek.moitech.malib")
class MalibApplicationTests {

	@Autowired
	BookService bookService;

	@Autowired
	AmazonS3 amazonS3;

	@Test
	void test() {
		bookService.getBookList().forEach(book -> System.out.println(book.getName()));
	}

	@Test
	void testAmazonS3() {
		System.out.println(amazonS3.doesBucketExistV2("linh-ne"));
	}
}
