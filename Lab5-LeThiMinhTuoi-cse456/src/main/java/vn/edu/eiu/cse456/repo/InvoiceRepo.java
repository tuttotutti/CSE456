package vn.edu.eiu.cse456.repo;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse456.entities.Invoice;
import vn.edu.eiu.cse456.infra.JpaUtil;

import java.time.LocalDate;
import java.util.List;

public class InvoiceRepo {

    public static void save(Invoice invoice) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(invoice);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Invoice invoice) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(invoice);
        em.getTransaction().commit();
        em.close();
    }

    public static void delete(Invoice invoice) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(invoice)) {
            invoice = em.find(Invoice.class, invoice.getId());
        }
        if (invoice != null) {
            em.remove(invoice);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static List<Invoice> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Invoice> invoices = em.createQuery("SELECT i FROM Invoice i", Invoice.class)
                .getResultList();
        em.close();
        return invoices;
    }

    public static List<Invoice> findByDate(LocalDate date) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Invoice> invoices = em.createQuery(
                        "SELECT i FROM Invoice i WHERE i.date = :date", Invoice.class)
                .setParameter("date", date)
                .getResultList();
        em.close();
        return invoices;
    }

    public static Invoice findById(long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Invoice invoice = em.find(Invoice.class, id);
        em.close();
        return invoice;
    }
}
