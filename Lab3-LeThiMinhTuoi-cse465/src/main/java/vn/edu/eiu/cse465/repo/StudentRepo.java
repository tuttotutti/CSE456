package vn.edu.eiu.cse465.repo;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse465.entity.Student;
import vn.edu.eiu.cse465.infra.JpaUtil;

import java.util.List;

public class StudentRepo {
    public static void save(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Student removedStudent = null;
        if (em.contains(student)) {
            removedStudent = em.find(Student.class, student.getStudentId());
        }
        if (removedStudent != null) {
            em.remove(student);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static Student findStudentById(String studentId) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = em.find(Student.class, studentId);
        em.close();
        return student;
    }

    public static List<Student> findAllStudent() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        em.close();
        return students;
    }

    public static List<Student> findStudentByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.studentName LIKE :name", Student.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        em.close();
        return students;
    }
}
