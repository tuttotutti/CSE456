package vn.edu.eiu.cse456.fecse456studentiddemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.Student;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,String> {
    List<Student> searchAllByNameContainingIgnoreCase(String keyword);
}
