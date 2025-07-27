package vn.edu.eiu.cse465.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    static{
        try{
            emf = Persistence.createEntityManagerFactory("pu1-lab3");
        } catch(Exception e){
            System.err.println("Cannot create EntityManagerFactory" + e.getMessage());
            throw new RuntimeException("Failed to initialize EntityManagerFactory", e);
        }
    }

    public JpaUtil(){}

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
