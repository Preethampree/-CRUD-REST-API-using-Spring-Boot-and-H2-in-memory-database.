package com.example.demo.controller;

import com.example.demo.model.Usero;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Usero> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public Usero createUser(@RequestBody Usero user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Usero getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Usero updateUser(@PathVariable Long id, @RequestBody Usero userDetails) {
        Usero user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
