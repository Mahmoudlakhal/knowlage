package com.gladiators.pi_spring.Services.Interfaces;

import com.gladiators.pi_spring.Entities.User;

import java.util.List;

public interface IServiceUser {
    public User ajouterUser (User user);
    public List<User> getAllUsers();

    void removeUser(Long IdUser);

    public User updateUser(Long idUser,User user);

}
