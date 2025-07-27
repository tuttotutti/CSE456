package vn.edu.eiu.cse465.repo;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse465.entity.School;
import vn.edu.eiu.cse465.infra.JpaUtil;

import java.util.List;

public class SchoolRepo {
    public static void save(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        School removedSchool = null;
        if (em.contains(school)) {
            removedSchool = em.find(School.class, school.getSchoolId());
        }
        if (removedSchool != null) {
            em.remove(school);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static School findSchoolById(String schoolId) {
        EntityManager em = JpaUtil.getEntityManager();
        School school = em.find(School.class, schoolId);
        em.close();
        return school;
    }

    public static List<School> findAllSchool() {
        EntityManager em = JpaUtil.getEntityManager();
        List<School> schools = em.createQuery("SELECT s FROM School s", School.class).getResultList();
        em.close();
        return schools;
    }

    public static List<School> findSchoolByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        List<School> schools = em.createQuery("SELECT s FROM School s WHERE s.schoolName LIKE :name", School.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        em.close();
        return schools;
    }
}
