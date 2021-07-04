package kindle.db;

import javax.persistence.EntityManager;

import kindle.entities.Publisher;

public class PublisherDAO {

	static public int persist(Publisher publisher) {
		EntityManager em = UtilDB.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(publisher);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return publisher.getId();
	}
}
