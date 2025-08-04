package vn.edu.eiu.cse456.repo;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse456.entities.Product;
import vn.edu.eiu.cse456.infra.JpaUtil;

import java.util.List;

public class ProductRepo {

    public static void save(Product product) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Product product) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        em.close();
    }

    public static void delete(Product product) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(product)) {
            product = em.find(Product.class, product.getId());
        }
        if (product != null) {
            em.remove(product);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static List<Product> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
        em.close();
        return products;
    }

    public static Product findById(long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Product product = em.find(Product.class, id);
        em.close();
        return product;
    }

    public static List<Product> findByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Product> products = em.createQuery(
                        "SELECT p FROM Product p WHERE p.name LIKE :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        em.close();
        return products;
    }

    public static List<Product> findByPrice(double minPrice, double maxPrice) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Product> products = em.createQuery(
                        "SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max", Product.class)
                .setParameter("min", minPrice)
                .setParameter("max", maxPrice)
                .getResultList();
        em.close();
        return products;
    }

    public static List<Product> findByStock(int stockThreshold) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Product> products = em.createQuery(
                        "SELECT p FROM Product p WHERE p.stock >= :stock", Product.class)
                .setParameter("stock", stockThreshold)
                .getResultList();
        em.close();
        return products;
    }
}
