package ibtech.task01;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import entities.customer;
import junit.framework.TestCase;

public class HibernateConnection extends TestCase{

	@Test
	public void crud() {
		
		
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        create(session);
        read(session);
         
        update(session);
        read(session);
         
        //delete(session);
        read(session);
         
        session.close();
	}
	
	private void create(Session session) {
		
		System.out.println("Customer information is being created...");
		customer cst1 = new customer(1, "emre", "yananli", 12345678, new Date(1999, 05, 03), "huseyinemre.yananli@ibtech.com.tr");
		customer cst2 = new customer(2, "ib", "tech", 45665443, new Date(2000, 01, 01), "ibtech@gmail.com.tr" );

		session.beginTransaction();
        session.save(cst1);
        session.save(cst2);
        session.getTransaction().commit();
	}
	
	private void read(Session session) {
		
		  List<?> customer = session.createQuery("from customer").list();
	        for(Object i: customer) {
	        	customer c = (customer) i;
	        	System.out.println(String.format("Customer Name: %s , Customer Surname: %s, Customer Email : %s",
	        			c.getFirstName(),c.getLastName(),c.getEmailAddress()));
	        }
	}
	
	private void update(Session session) {
        System.out.println("Updating customer information");
        customer cst1 = (customer) session.get(customer.class, "first customer");
        cst1.setTcNo(87654321);
        cst1.setEmailAddress("emreyananli@yahoo.com");
         
        session.beginTransaction();
        session.saveOrUpdate(cst1);
        session.getTransaction().commit();
    }
	
	private void delete(Session session) {
        System.out.println("Deleting ibtech record...");
        customer cst2 = (customer) session.get(customer.class, "ibtech");
         
        session.beginTransaction();
        session.delete(cst2);
        session.getTransaction().commit();
    }
}