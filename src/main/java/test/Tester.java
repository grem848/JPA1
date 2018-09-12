
package test;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Tester
{
    public static void main(String[] args)
    {
        // Persistence.generateSchema("pu", null);
        Customer c1 = new Customer("Kurt Wonnegut");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(c1);
            em.getTransaction().commit();
            
            System.out.println("ID: " + c1.getId());
            
            int id = c1.getId();
            Customer c1Again = em.find(Customer.class, id);
            
            System.out.println(c1Again.toString());
            
            // Ekstra opgave --> Lav facade klasse efter mønster i slides 
            
        } finally
        {
            em.close();
        }
    }
    
}
