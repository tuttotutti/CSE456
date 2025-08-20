package vn.edu.eiu.cse456.fecse456studentiddemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.Major;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.Student;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.User;
import vn.edu.eiu.cse456.fecse456studentiddemo.service.MajorService;
import vn.edu.eiu.cse456.fecse456studentiddemo.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {
    //Inject service for do the data
    @Autowired // Inject = field
    MajorService majorService;

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Major m1 = new Major("CSE","Computer Science Engineering");
        Major m2 = new Major("CSW","Computer Science WHAT");

        Student st1m1 = new Student("st1m1","Le Thi Minh Tuoi",2004, 100);
        Student st2m1 = new Student("st2m1", "Le Thi Minh Tien", 2002, 101);
        Student st3m2 = new Student("st3m2", "Ha Thi Lich", 2009, 102);
        Student st4m2 = new Student("st4m2", "Le Minh Toan", 2000, 103);

        //Add students to major
        m1.addStudent(st1m1);
        m1.addStudent(st2m1);
        m2.addStudent(st3m2);
        m2.addStudent(st4m2);

        //Call service saving database
        majorService.saveMajor(m1);
        majorService.saveMajor(m2);

        //Add a new user
        User admin = new User("admin","admin",1);
        User staff = new  User("staff","staff",2);
        User student = new  User("student","student",3);
        userService.save(admin);
        userService.save(staff);
        userService.save(student);
    }
}
