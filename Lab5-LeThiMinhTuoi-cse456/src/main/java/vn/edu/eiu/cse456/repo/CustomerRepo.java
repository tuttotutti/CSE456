package vn.edu.eiu.cse456.repo;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.cse456.entities.Customer;
import vn.edu.eiu.cse456.infra.JpaUtil;

import java.util.List;

@Repository
public class CustomerRepo {
    public static void save(Customer c){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Customer c){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        em.close();
    }

    public static void delete(Customer c){
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(c)) {
            c = em.find(Customer.class, c.getId());
        }
        if (c != null) {
            em.remove(c);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static List<Customer> findAll(){
        EntityManager em = JpaUtil.getEntityManager();
        List<Customer> customers = em.createQuery("SELECT c FROM Customer c").getResultList();
        em.close();
        return customers;
    }

    public static List<Customer> findCustomerByName(String name){
        EntityManager em = JpaUtil.getEntityManager();
        List<Customer> customers = em.createQuery("SELECT c FROM Customer c WHERE c.name LIKE :name").setParameter("name", "%" + name + "%").getResultList();
        em.close();
        return customers;
    }

    public static Customer findCustomerById(long id){
        EntityManager em = JpaUtil.getEntityManager();
        Customer customer = em.find(Customer.class, id);
        em.close();
        return customer;
    }
}
