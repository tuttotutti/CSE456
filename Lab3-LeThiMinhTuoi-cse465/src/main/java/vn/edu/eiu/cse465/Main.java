package vn.edu.eiu.cse465;

import vn.edu.eiu.cse465.entity.Major;
import vn.edu.eiu.cse465.entity.School;
import vn.edu.eiu.cse465.entity.Student;
import vn.edu.eiu.cse465.service.MajorService;
import vn.edu.eiu.cse465.service.SchoolService;
import vn.edu.eiu.cse465.service.StudentService;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        School school1 = new School("EIU", "Eastern");
//        School school2 = new School("EEE", "Easssssss");
//
//        Major cseMajor = new Major("CSE","CSEEEEEE");
//        Major aaaMajor = new Major("AAA", "iefjiwhfeigheig");
//
//        Student st1 = new Student("eeeeeeeeeeeeee");
//        Student st2 = new Student("jjjjjjjjjjjjj");
//
//        school1.addMajor(cseMajor);
//        school2.addMajor(aaaMajor);
//
//        school1.addStudent(st1);
//        school2.addStudent(st2);
//
//        cseMajor.addStudent(st1);
//        aaaMajor.addStudent(st2);
//
//        SchoolService schoolService = new SchoolService();
//        schoolService.saveSchool(school1);
//        schoolService.saveSchool(school2);
//
        MajorService majorService = new MajorService();
//
//        StudentService studentService = new StudentService();
//
//        School school = schoolService.findSchoolById("EIU");
//        System.out.println(school.getSchoolId() + " " + school.getSchoolName());
//
//        cseMajor.setMajorName("oooooooooooooo");
//        majorService.updateMajor(cseMajor);
//
//        majorService.removeMajor(aaaMajor);

        School school3 = new School("204i3", "ieifheifh");
        Major oooMajor = new Major("OOO", "iiiiiiiiiiiiiii");
        SchoolService schoolService = new SchoolService();
        school3.addMajor(oooMajor);
        schoolService.saveSchool(school3);
        majorService.removeMajor(oooMajor);
        List<Major> majors = majorService.findAllMajors();
        for(Major major : majors){
            System.out.println(major.getMajorId()+" "+major.getMajorName()+"\n");
        }



    }
}