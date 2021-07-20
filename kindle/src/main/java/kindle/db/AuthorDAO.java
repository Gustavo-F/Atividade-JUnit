package kindle.db;

import java.util.List;

import javax.persistence.EntityManager;

import kindle.entities.Author;
import kindle.entities.Author;

public class AuthorDAO {

	static public int persist(Author author) {
		EntityManager em = UtilDB.getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(author);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return author.getId();
	}

	static public List<Author> persistList(List<Author> authors) {
		for (int i = 0; i < authors.size(); i++)
			authors.get(i).setId(persist(authors.get(i)));

		return authors;
	}
}
