package kindle.db;

import javax.persistence.EntityManager;

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
}
