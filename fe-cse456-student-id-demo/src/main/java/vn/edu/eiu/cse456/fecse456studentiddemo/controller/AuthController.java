package vn.edu.eiu.cse456.fecse456studentiddemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.User;
import vn.edu.eiu.cse456.fecse456studentiddemo.service.UserService;

@Controller
public class AuthController {
    //inject via field
    @Autowired
    UserService userService;
    //method handing when a user presses login
    @PostMapping("/auth")
    public String doLogin(@ModelAttribute User user, HttpSession ses, RedirectAttributes redirectAttributes){
        User loginUser = userService.findByUsername(user.getUsername());
        if(loginUser==null){
            redirectAttributes.addFlashAttribute("errLogin","Username or password not found");
            redirectAttributes.addFlashAttribute("username", user.getUsername());
            return "redirect:/login";
        }
        if(!loginUser.getPassword().equals(user.getPassword())){
            redirectAttributes.addFlashAttribute("username", user.getUsername());
            return "redirect:/login";
        }
        //inject userService

        //compare username to db, if not found -> back to login
        //session used throughout the whole
        ses.setAttribute("user",loginUser);
        return "redirect:/students";
    }

    //handle when clock with link/logout
    @GetMapping("/logout")
    public String logout(HttpSession ses){
//        ses.setAttribute("user",null);
        ses.invalidate();
        return "redirect:/login";
    }

    @GetMapping({"/","/login"})
    public String showLoginPage(){
        return "login";
    }
}
