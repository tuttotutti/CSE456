package vn.edu.eiu.cse456.lab6minhtuoicse456_second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.cse456.lab6minhtuoicse456_second.config.InitStudent;
import vn.edu.eiu.cse456.lab6minhtuoicse456_second.entity.Student;

import java.util.List;

@Controller // Process and return a html web
public class StudentController {
    //Initialize a student list
    private final InitStudent initStudent;

    @Autowired
    public StudentController(InitStudent initStudent){
        this.initStudent = initStudent;
    }

    // Show index page
//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

    // Call student list for url
    @GetMapping("/students")
    public String showStudents( Model model){
        List<Student> students = initStudent.getStudentList();
        model.addAttribute("students", students);
        return "student-list"; // THis is file html: student-list.html
    }

    //Handle page localhost:8080/students/edit
    @GetMapping("/students/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id){
        /*
         * Works needed to do:
         * Attach form containing all info of students that is needed to be editted
         * Save button to save info
         * Return html page containing form edit students
         */
        for(Student foundStudent : initStudent.getStudentList()){
            if(foundStudent.getId() == id){
                model.addAttribute("student", foundStudent);
                break;
            }
        }
        return "student-form"; //student-form.html
    }

    /*
    After handling form:
     - After handling and return to html, but url is unchanged, it's still the same url of action form => if press f5 (refresh), then call this method again to handle => resubmission form
     - In the case of adding new data, with auto-incremental id => duplicated data
     */
    //Version 2: use redirect to avoid errors
    @PostMapping("/students/edit/result")
    public String saveStudent(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("yob") String yob, @RequestParam("gpa") String gpa, RedirectAttributes redirectAttributes){
        /*
        Take info from form
        Display that info on result.html
         */
        redirectAttributes.addFlashAttribute("pmsg", "The student info is saved successfully!!!");
        redirectAttributes.addFlashAttribute("pid", id);
        redirectAttributes.addFlashAttribute("pname", name);
        redirectAttributes.addFlashAttribute("pyob", yob);
        redirectAttributes.addFlashAttribute("pgpa", gpa);
        return "redirect:/student/edit/result"; //result.html
    }

    @GetMapping("/student/edit/result")
    public String showResult(Model model){
        return "result"; //result.html
    }
}
