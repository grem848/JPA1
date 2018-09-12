package facade;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CustomerFacade
{

    EntityManagerFactory emf;

    public CustomerFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public Customer createCustomer(String name)
    {
        Customer temp = new Customer(name);
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();

            em.persist(temp);

            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
        return temp;
    }

    public Customer createCustomer(Customer cust)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();

            em.persist(cust);

            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
        return cust;
    }

    public Customer getCustomer(int id)
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(Customer.class, id);
            
        } finally
        {
            em.close();
        }
    }
}
