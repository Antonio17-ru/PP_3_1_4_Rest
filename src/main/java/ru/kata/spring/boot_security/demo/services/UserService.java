package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findById(int id);

    List<User> findAll();

    void saveUser(User user, Set<Role> roles);

    void deleteById(int id);

    Set<Role> getAllRoles();

}
