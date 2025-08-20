package vn.edu.eiu.cse456.fecse456studentiddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.Student;
import vn.edu.eiu.cse456.fecse456studentiddemo.repo.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    //Inject dependency repo to do db
    @Autowired
    StudentRepo studentRepo;

    //Method saving student to db
    public void save(Student student){
        studentRepo.save(student);
    }

    //Method getting all students
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    //Method getting a student by id for editing
    public Student getStudentById(String id){
        return studentRepo.findById(id).orElseThrow(); // ham tu sinh
    }

    // method deleting a student
    public void deleteStudentById(String id){
        studentRepo.deleteById(id);
    }

    // method searching a student
    public List<Student> searchStudentsByName(String keyword){
        return studentRepo.searchAllByNameContainingIgnoreCase(keyword);
    }

    public Boolean checkExistsById(String id){
        return studentRepo.existsById(id);
    }
}
