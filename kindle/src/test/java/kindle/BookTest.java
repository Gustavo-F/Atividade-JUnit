package kindle;

import static org.junit.Assume.assumeFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kindle.db.AuthorDAO;
import kindle.db.PublisherDAO;
import kindle.db.UtilDB;
import kindle.entities.Author;
import kindle.entities.Book;
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
	
	@Test
	void testAuthorsList() {
		assumeFalse(book.verifyAuthorsList());
		assumeFalse(book.verifyPages());
	}
	
	@Test
	void testPages(){
		
	}
	
	@AfterAll
	static void close() {
		UtilDB.closeConn();
	}

}
