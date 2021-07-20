package kindle;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assume.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import kindle.db.AuthorDAO;
import kindle.db.BookDAO;
import kindle.db.PublisherDAO;
import kindle.db.UtilDB;
import kindle.entities.Author;
import kindle.entities.Book;
import kindle.entities.Publisher;

class BookTest {
	
	static Book book = null;
	static Publisher publisher;

	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	@BeforeAll
	static void init() {
		Author author = new Author("Gustao Ferreira Souza");
		author.setId(AuthorDAO.persist(author));
		
		Publisher publisher = new Publisher("Veja");
		publisher.setId(PublisherDAO.persist(publisher));

		book = new Book("Livro", 150, null);
	}	
	
	@BeforeEach
	void checkBook() {
		assertNotNull(book);
	}
	
	@Test
	void checkPublisher() {
		assertNull(book.getPublisher());
	}
		
	@Test
	void testAuthorsList() {
		assumeFalse(book.verifyAuthorsList());
	}
	
	@Test
	void testPages(){
		assumeTrue(book.verifyPages());
	}
	
	@AfterAll
	static void close() {
		BookDAO.persist(book);
		UtilDB.closeConn();
	}

}
