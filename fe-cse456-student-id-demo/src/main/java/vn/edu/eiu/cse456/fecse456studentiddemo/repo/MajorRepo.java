package vn.edu.eiu.cse456.fecse456studentiddemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.Major;

//JpaRepository is interface in spring data jpa. Containing all abstract methods handling CRUD on database
//When inheriting, it will pass the name of entity class and data type of the primary key
//In JpaRepository already built abstract methods for serving the basic calling to the database
@Repository
public interface MajorRepo extends JpaRepository<Major,Integer> {

}
