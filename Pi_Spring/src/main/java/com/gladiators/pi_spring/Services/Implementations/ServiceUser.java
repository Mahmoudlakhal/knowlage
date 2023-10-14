package com.gladiators.pi_spring.Services.Implementations;

import com.gladiators.pi_spring.Entities.User;
import com.gladiators.pi_spring.Repositories.UserRepository;
import com.gladiators.pi_spring.Services.Interfaces.IServiceUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ServiceUser implements IServiceUser {
    @Autowired
    UserRepository userRepository;

    public User ajouterUser (User user){

        log.info("utilisateur ajouté ");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(Long IdUser) {
        userRepository.deleteById(IdUser);
    }

    @Override
    @Transactional
    public User updateUser(Long idUser,User user) {
        User UserP = userRepository.findById(idUser).orElse(null);
        if (UserP == null) {
            return null;
        }
        UserP.setFirstName(user.getFirstName());
        UserP.setLastName(user.getLastName());
        UserP.setPassword(user.getPassword());
        UserP.setEmail(user.getEmail());
        UserP.setPhoneNumber(user.getPhoneNumber());
        UserP.setAdresse(user.getAdresse());


        return userRepository.save(UserP);
    }



}
