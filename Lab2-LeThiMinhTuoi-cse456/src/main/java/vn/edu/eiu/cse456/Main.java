package vn.edu.eiu.cse456;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.eiu.cse456.entity.Student;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        insertStudent();
        updateStudentById();
        getStudentById();
        getAllStudents();
        getStudentsByGpa();
        searchStudentByConditions(1,"Lan Le");
        deleteStudentById();

    }

    public static void insertStudent(){
        EntityManager em = emf.createEntityManager();
        Student st1 = new Student("CSE2025001","Lan Le",2000,8.5);
        Student st2 = new Student("CSE2025002","Lan Le",2000,10.5);
        Student st3 = new Student("CSE2025003","Lan Le",2000,0.5);
        em.getTransaction().begin();
//        em.persist(st1);
        em.persist(st2);
        em.persist(st3);
        em.getTransaction().commit();
        em.close();
    }

    public static void getStudentById(){
        EntityManager em = emf.createEntityManager();
        Student st = em.find(Student.class, "CSE2025001");
        System.out.println("Student found:"+st.toString());
    }

    public static void getAllStudents(){
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("select s from Student s", Student.class).getResultList();
        System.out.println("The list of all students:");
        for(Student s: students){
            System.out.println("Student found:"+s.toString());
        }
    }

    public static void getStudentsByGpa(){
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("select s from Student s WHERE s.gpa > 8", Student.class).getResultList();
        System.out.println("The size of the students:"+students.size());
        em.close();
    }

    public static void updateStudentById(){
        EntityManager em = emf.createEntityManager();
        Student st = em.find(Student.class, "CSE2025001");
        em.getTransaction().begin();
        st.setGpa(2);
        em.getTransaction().commit();
        em.close();
    }

    //Search Student by multiple conditions name gpa ("Lan Le",2.0)
    public static void searchStudentByConditions(double Gpa, String Name){
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("select s from Student s WHERE s.gpa > :pGpa AND s.name like :pName", Student.class).setParameter("pName","%"+Name+"%").setParameter("pGpa",Gpa).getResultList();
        students.forEach(s -> System.out.println("Student found:"+s.toString()));
    }

    public static void deleteStudentById(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student st = em.find(Student.class, "CSE2025001");
        em.remove(st);
        em.getTransaction().commit();
        System.out.println("Student has been removed.");
        em.close();
    }

    //update by conditionS
}