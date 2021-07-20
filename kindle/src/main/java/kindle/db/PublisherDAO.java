package kindle.db;

import java.util.Iterator;
import java.util.List;

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
	
	static public List<Publisher> persistList(List<Publisher> publishers) {
		for (int i = 0; i < publishers.size(); i++)
			publishers.get(i).setId(persist(publishers.get(i)));

		return publishers;
	}
}
