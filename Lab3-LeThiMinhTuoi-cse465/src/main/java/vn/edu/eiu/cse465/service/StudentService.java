package vn.edu.eiu.cse465.service;

import vn.edu.eiu.cse465.entity.Student;
import vn.edu.eiu.cse465.repo.StudentRepo;

import java.util.List;

public class StudentService {

    public void saveStudent(Student student) {
        StudentRepo.save(student);
    }

    public void updateStudent(Student student) {
        StudentRepo.update(student);
    }

    public void removeStudent(Student student) {
        StudentRepo.remove(student);
    }

    public Student findStudentById(String studentId) {
        return StudentRepo.findStudentById(studentId);
    }

    public List<Student> findAllStudents() {
        return StudentRepo.findAllStudent();
    }

    public List<Student> findStudentsByName(String name) {
        return StudentRepo.findStudentByName(name);
    }
}
