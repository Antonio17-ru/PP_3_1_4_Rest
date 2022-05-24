package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class MainController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public MainController(UserService userService,
                          UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

//   @GetMapping("/{id}")
//   public String allUser(@PathVariable("id") int id, Model model) {
//       model.addAttribute("user", userService.findById(id));
//       return "admin";
//   }

    @GetMapping()
    public String showAllUsers(Model model, Principal principal) {
        List<User> users = userService.findAll();
        List<Role> listRoles = userService.listRoles();
        model.addAttribute("userRep", userRepository.findByUsername(principal.getName()));
        model.addAttribute("users", users);
        model.addAttribute("user.roles", users);
        model.addAttribute("userObj", new User());
        model.addAttribute("listRoles", listRoles);
        return "admin";
    }

    @PostMapping("/create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/update")
    public String updateUserForm(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

}
