package vn.edu.eiu.cse465.repo;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse465.entity.Major;
import vn.edu.eiu.cse465.infra.JpaUtil;

import java.util.List;
import java.util.jar.JarEntry;

public class MajorRepo {
    public static void save(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Major removedMajor = em.find(Major.class, major.getMajorId());
        if(removedMajor != null) {
            em.remove(major);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static Major findMajorById(String majorId){
        EntityManager em = JpaUtil.getEntityManager();
        Major  major = em.find(Major.class, majorId);
        em.close();
        return major;
    }

    public static List<Major> findAllMajor(){
        EntityManager em = JpaUtil.getEntityManager();
        List<Major> majors = em.createQuery("SELECT m FROM Major m", Major.class).getResultList();
        em.close();
        return majors;
    }

    public static List<Major> findMajorByName(String name){
        EntityManager em = JpaUtil.getEntityManager();
        List<Major> majors = em.createQuery("SELECT m FROM Major m WHERE m.majorName LIKE :name", Major.class).setParameter("name", "%" + name + "%").getResultList();
        em.close();
        return majors;
    }
}
