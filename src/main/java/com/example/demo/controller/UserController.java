package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listProduct(){
        List<User> users = new ArrayList<>();
        users=userService.listAllUser();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User>getById(@PathVariable Integer id){
        User user=userService.getUser(id);
        if(user==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(user));
    }

    @PostMapping
    public ResponseEntity<User> newUser(@RequestBody  User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.edit(user,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteProduct(@PathVariable Integer id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
