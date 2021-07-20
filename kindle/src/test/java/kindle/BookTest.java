package kindle;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assume.assumeFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.ArrayList;
import java.util.List;
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

	static Book book1;
	static Book book2;
	static List<Publisher> publishers = new ArrayList<>();
	static List<Author> authors = new ArrayList<>();	
	
	@Test
	@BeforeAll
	static void createInitialData() {
		UtilDB.getEntityManager();

		Author author = new Author("Gustao Ferreira Souza");
		authors.add(author);
		
		Publisher publisher = new Publisher("Veja");
		publishers.add(publisher);
		
		book1 = new Book("Livro", 150, null);
		book2 = new Book("Livro 2", 240, publisher);
	}
	
	@Test
	@Timeout(value = 2, unit = TimeUnit.SECONDS)
	void saveInitialData() { 
		publishers = PublisherDAO.persistList(publishers);
		authors = AuthorDAO.persistList(authors);
	}
		
	@BeforeEach
	void checkBook() {
		assertNotNull(book1);
		assertNotNull(book2);
	}
	
	@Test
	void checkBookTitles() {
		assertNotEquals(book1.getTitle(), book2.getTitle());
	}
	
	@Test
	void checkPublisher() {
		assertNull(book1.getPublisher());
	}
		
	@Test
	void testAuthorsList() {
		assumeFalse(book1.verifyAuthorsList());
	}
	
	@Test
	void testPages(){
		assumeTrue(book1.verifyPages());
	}
	
	@AfterAll
	static void close() {
		BookDAO.persist(book1);
		BookDAO.persist(book2);
		UtilDB.closeConn();
	}

}
