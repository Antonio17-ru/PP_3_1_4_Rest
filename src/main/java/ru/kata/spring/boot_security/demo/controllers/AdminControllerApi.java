package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;


@RestController
@RequestMapping("admin/api/users")
public class AdminControllerApi {

    private final UserService userService;

    @Autowired
    public AdminControllerApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> showAllUser() {
        List<User> allUsers = userService.findAll();
        return allUsers;
    }

    @GetMapping("{id}")
    public User getOneUser(@PathVariable("id") int id) {
        return userService.getById(id);
    }

    @PostMapping()
    public User createNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

}
