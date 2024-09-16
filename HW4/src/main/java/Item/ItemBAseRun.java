package Item;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import ir.freeland.springboot.persistence.model.Items;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class ItemBAseRun {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public void sampleRun() {
		entityManager=entityManager.getEntityManagerFactory().createEntityManager();		
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction = session.getTransaction();
		
		//Save*****************************************
		transaction.begin();
		Items item = new Items();
		item.setName("bulm");
		item.setPrice(124.98);
    	item.setCataloge("SkinCare");
    	entityManager.persist(item);
    	transaction.commit();
    	
    	//Find*****************************************
    	transaction.begin();
    	List<Items> items = session.createQuery("from items" , Items.class).getResultList();
    	items.stream().forEach( i -> System.out.println(i));    	
    	transaction.commit();

    	//Update *****************************************
    	transaction.begin();
    	items.get(0).setName("cream pouder");
    	transaction.commit();
    	
    	//Delete *****************************************
    	//transaction.begin();
    	//session.remove(  items.get(0) );
    	//transaction.commit();
    	
    	
	}
}
