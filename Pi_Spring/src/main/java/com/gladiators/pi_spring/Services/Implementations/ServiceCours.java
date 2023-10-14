package com.gladiators.pi_spring.Services.Implementations;

import com.gladiators.pi_spring.Entities.Cours;
import com.gladiators.pi_spring.Entities.Image;
import com.gladiators.pi_spring.Entities.TD;
import com.gladiators.pi_spring.Entities.User;
import com.gladiators.pi_spring.Repositories.CoursRespository;
import com.gladiators.pi_spring.Repositories.UserRepository;
import com.gladiators.pi_spring.Services.Interfaces.IServiceCours;
import com.gladiators.pi_spring.file_service.Repository.IImageRepo;
import com.gladiators.pi_spring.file_service.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ServiceCours implements IServiceCours{

    @Autowired
    public CoursRespository coursRespository;


    @Override
    public Cours AddCours(Cours cours){
        coursRespository.save(cours);
        return cours;
    }
    @Override
    public List<Cours> retrieveAllCours(){
        List<Cours> coursList = coursRespository.findAll();
        return coursList;
    }

    @Override
    public byte[] getCoursImageById(Long coursId) {
        // Recherchez le cours en fonction de son ID
        Cours cours = coursRespository.findById(coursId).orElse(null);

        if (cours == null) {
            // Gérez le cas où le cours n'est pas trouvé (par exemple, renvoyez une image par défaut ou une erreur)
            return null;
        }
        // Récupérez les données de l'image du cours
        byte[] imageData = cours.getImage();

        return imageData;
    }


    @Override
    public byte[] getCoursVideoById(Long coursId) {
        // Recherchez le cours en fonction de son ID
        Cours cours = coursRespository.findById(coursId).orElse(null);

        if (cours == null) {
            // Gérez le cas où le cours n'est pas trouvé (par exemple, renvoyez une image par défaut ou une erreur)
            return null;
        }
        // Récupérez les données de l'image du cours
        byte[] videoData = cours.getVideo();

        return videoData;
    }


    public Cours getCoursById(Long id) {
        Optional<Cours> coursOptional = coursRespository.findById(id);
        return coursOptional.orElse(null);
    }
}
