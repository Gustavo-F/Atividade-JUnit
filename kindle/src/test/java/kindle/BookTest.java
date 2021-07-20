package kindle;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import kindle.db.UtilDB;
import kindle.db.AuthorDAO;
import kindle.entities.Book;
import kindle.db.PublisherDAO;
import kindle.entities.Author;
import kindle.entities.Publisher;

class BookTest {
	
	static Book book = null;

	@BeforeAll
	static void init() {
		System.out.println("@SuppressWarnings(\"unused\")");
		Author author = new Author("Gustao Ferreira Souza");
		author.setId(AuthorDAO.persist(author));
		
		Publisher publisher = new Publisher("Veja");
		publisher.setId(PublisherDAO.persist(publisher));

		book = new Book("Livro", 150, publisher);
	}	
	
	@BeforeEach
	void checkBook() {
		assertNotNull(book);
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
		UtilDB.closeConn();
	}

}
