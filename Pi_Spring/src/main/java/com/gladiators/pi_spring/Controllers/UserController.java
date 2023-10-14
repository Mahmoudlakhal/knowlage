package com.gladiators.pi_spring.Controllers;

import com.gladiators.pi_spring.Entities.User;
import com.gladiators.pi_spring.Services.Interfaces.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 @Autowired
    IServiceUser userIservice;

    @PostMapping("/ajouterUser")
    @ResponseBody
    public User ajouterUser (@RequestBody User user) {
        return userIservice.ajouterUser(user);
    }



    @GetMapping("/GetAllUser")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userIservice.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/remove-User/{idUser}")
    public void removeUser(@PathVariable("idUser") Long IdUser) {
        userIservice.removeUser(IdUser);
    }

    @PutMapping("/updateUser/{idUser}")
    @ResponseBody
    public User updateUser(@PathVariable("idUser") Long idUser, @RequestBody User user) {
        return userIservice.updateUser(idUser, user);
    }
}
