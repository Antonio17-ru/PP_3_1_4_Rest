package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(int id);

    List<Role> listRoles();



}
