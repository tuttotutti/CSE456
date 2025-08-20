package vn.edu.eiu.cse456.fecse456studentiddemo.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.Major;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.Student;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.User;
import vn.edu.eiu.cse456.fecse456studentiddemo.service.MajorService;
import vn.edu.eiu.cse456.fecse456studentiddemo.service.StudentService;

import java.util.ArrayList;
import java.util.List;
// Flow: UI -- Controller( here ) -- Service -- Repository -- ( JDBC ) -- DB( MySQL )
// for each url => need 1 method for handling
// to form, use @PostMapping

@Controller
public class StudentController {
    // inject service to do db
    @Autowired // inject by field
    private StudentService studentService;
    @Autowired
    private MajorService majorService;

    // url localhost:8080/students --> return student-list.html

    /**
     * when type the direct link/student, if the method handling has @RequestParam, then it will be Null
     */
    @GetMapping("students")
    public String students(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword , Model model, HttpSession ses) {

        //handling session, block typing the link: if not login -> login.html
        User user = (User)ses.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        List<Student> studentList = new ArrayList<>();

        if(keyword.isBlank()) {
            studentList = studentService.getAllStudents();
        }
        else {
            studentList = studentService.searchStudentsByName(keyword);
        }

        //Send via view
        model.addAttribute("studentList", studentList);
        return "student-list";// student-list.html

    }

    // method handling url: localhost:8080/student/edit/{id}
    @GetMapping("student/edit/{id}")
    public String editStudent(@PathVariable("id") String id, Model model, HttpSession ses, RedirectAttributes redirectAtt) {

        User user = (User) ses.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        //check adding role is 1 or 2
        if(user.getRole() != 1 && user.getRole() != 2){
            //notify errors access denied.
            redirectAtt.addFlashAttribute("errRole","Access Denied. You are not allowed to perform this action.");
            return "redirect:/students";
        }
        // get student with id from db
        Student s = studentService.getStudentById(id);
        model.addAttribute("student", s);

        //Send major list to select
        List<Major> majorList = majorService.getAllMajors();
        System.out.println(majorList.size());
        model.addAttribute("majorList", majorList);

        // Send an attribute to tell "add a new student"
        model.addAttribute("formMode","edit");
        return "student-form"; // return student-form.html

    }

    // method handling add a new student
    @GetMapping("/student/add")
    public String addStudent(Model model, HttpSession ses, RedirectAttributes redirectAtt) {

        User user = (User) ses.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        //check adding role is 1 or 2
        if(user.getRole() != 1 && user.getRole() != 2){
            //notify errors access denied.
            redirectAtt.addFlashAttribute("errRole","Access Denied. You are not allowed to perform this action.");
            return "redirect:/students";
        }

        // take all major to send via comboBox
        // note: attributeName needed to be the same as edit method
        List<Major> majorList = majorService.getAllMajors();
        model.addAttribute("majorList", majorList);

        // Create and save a new student
        // note: attributeName needed to be the same as in edit method
        model.addAttribute("student", new Student());

        // Send an attribute to tell "add a new student"
        model.addAttribute("formMode","add");
        return "student-form";

    }

    // method handling url /student/form when hititng save button
    @PostMapping("/student/form")
    public String saveStudent(@Valid @ModelAttribute("student") Student s, BindingResult result, Model model, @RequestParam("formMode") String formMode, HttpSession ses, RedirectAttributes redirectAtt) {

        User user = (User) ses.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        //check adding role is 1 or 2
        if(user.getRole() != 1 && user.getRole() != 2){
            //notify errors access denied.
            redirectAtt.addFlashAttribute("errRole","Access Denied. You are not allowed to perform this action.");
            return "redirect:/students";
        }

        // take info from form, if has errors, back to form page with a message
        if(result.hasErrors()) {
            model.addAttribute("formMode", formMode);
            model.addAttribute("majorList", majorService.getAllMajors());
            return "student-form";
        }

        // Take key to db to check if it already exists or not
        // If exists, back to form announcing duplication
        // Announce errors
        if(formMode.equals("add")) {
            if(studentService.checkExistsById(s.getId())) {
                model.addAttribute("formMode", formMode);
                model.addAttribute("majorList", majorService.getAllMajors());
                model.addAttribute("duplicateId","Id already exists.");
                return "student-form";
            }
        }

        studentService.save(s);
        return "redirect:/students";

    }

    // method handling deleting
    @GetMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id, HttpSession ses, RedirectAttributes redirectAtt) {

        User user = (User) ses.getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }
        //check adding role is 1 or 2
        if(user.getRole() != 1){
            //notify errors access denied.
            redirectAtt.addFlashAttribute("errRole","Access Denied. You are not allowed to perform this action.");
            return "redirect:/students";
        }

        // Implement deleting the student
        studentService.deleteStudentById(id);
        // Return student-list page
        return "redirect:/students";

    }
}
