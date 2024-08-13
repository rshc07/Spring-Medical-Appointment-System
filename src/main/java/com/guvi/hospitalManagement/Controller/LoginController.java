package com.guvi.hospitalManagement.Controller;

import com.guvi.hospitalManagement.Entity.User;
import com.guvi.hospitalManagement.Exception.UserAlreadyExistsException;
import com.guvi.hospitalManagement.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Tag(name = "User Management System", description = "APIs for managing user login and registration")
public class LoginController {

    @Autowired
    private UserService userService;

    @Operation(summary = "View the login page")
    @GetMapping("/")
    public String index(){
        return "login";
    }
    @Operation(summary = "View the login page")
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @Operation(summary = "View the registration form")
    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }
    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, HttpSession session) {
        try {
            User userInfo = userService.saveUser(user);

            if (userInfo != null) {
                session.setAttribute("msg", "Register successfully");
            } else {
                session.setAttribute("msg", "Something wrong server");
            }
        } catch (UserAlreadyExistsException e) {
            session.setAttribute("msg", e.getMessage());
            return "redirect:/register";
        }

        return "redirect:/login";
    }
    @Operation(summary = "View the home page")
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
