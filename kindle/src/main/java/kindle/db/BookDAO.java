package kindle.db;

import javax.persistence.EntityManager;

import kindle.entities.Book;

public class BookDAO {

	public static int persist(Book book) {
		EntityManager em = UtilDB.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(book);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return book.getId();
	}
}
