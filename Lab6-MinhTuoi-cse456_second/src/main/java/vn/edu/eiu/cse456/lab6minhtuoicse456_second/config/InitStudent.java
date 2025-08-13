package vn.edu.eiu.cse456.lab6minhtuoicse456_second.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import vn.edu.eiu.cse456.lab6minhtuoicse456_second.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Component // Give to spring to manage
public class InitStudent {
    private List<Student> studentList;

    //Initialize a student list: hard-coded
    @PostConstruct //Automatically run when initializing obj InitStudent
    public void initStudent(){
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Minh Tui", 2004,90));
        studentList.add(new Student(2,"Minh Tien", 2002,95));
        studentList.add(new Student(3,"Thi Lich", 2000,100));
        studentList.add(new Student(4,"Minh Toan", 2001,10));
        studentList.add(new Student(5,"Minh Tri", 2004,90));
        System.out.println("The list of students is initialized successfully");
    }

    public List<Student> getStudentList(){
        return studentList;
    }
}
