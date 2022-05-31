package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User getById(int id);

    List<User> findAll();

    void deleteById(int id);

    Set<Role> getAllRoles();

    void saveUser(User user);

    void updateUser(User updatedUser);
}
