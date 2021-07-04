package kindle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kindle.db.AuthorDAO;
import kindle.entities.Author;
import kindle.entities.Book;

class BookTest {
	
	static List<Author> authors = new ArrayList<Author>();
	static Book book = null;

	@BeforeAll
	static void init() {
		Author author = new Author("Gustao Ferreira Souza");
		author.setId(AuthorDAO.persist(author));
		System.out.println(author.getId());
		
	}	
	
	@Test
	void test() {
		assertEquals(1, authors.get(1).getId());
	}

}
