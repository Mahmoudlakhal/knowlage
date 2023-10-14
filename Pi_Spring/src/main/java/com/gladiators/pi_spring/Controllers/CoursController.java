package com.gladiators.pi_spring.Controllers;

import com.gladiators.pi_spring.Entities.Categorie;
import com.gladiators.pi_spring.Entities.Cours;
import com.gladiators.pi_spring.Entities.Prix;
import com.gladiators.pi_spring.Entities.TD;
import com.gladiators.pi_spring.Repositories.CoursRespository;
import com.gladiators.pi_spring.Services.Interfaces.IServiceCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Cours")
@CrossOrigin(origins = "http://localhost:4200")
public class CoursController {

    @Autowired
    public IServiceCours iServiceCours;
    @PostMapping("/addCours")
    public Cours addCours(@RequestParam("video") MultipartFile video , @PathParam("title") String title, @PathParam("subject") String subject, @PathParam("content") String content, @PathParam("prix") Prix prix, @PathParam("categorie") Categorie categorie, @RequestParam("image") MultipartFile image) throws IOException {
        Cours  cours =new Cours();
        cours.setVideo(video.getBytes());
        cours.setTitle(title);
        cours.setSubject(subject);
        cours.setContent(content);
        cours.setPrix(prix);
        cours.setCategorie(categorie);
        cours.setImage(image.getBytes());

        return iServiceCours.AddCours(cours);
    }
    @GetMapping("/display")
    public List<Cours> retrieveAll(){
        return iServiceCours.retrieveAllCours();
    }

    @GetMapping("/displayImage/{coursId}")
    public ResponseEntity<byte[]> displayImage(@PathVariable Long coursId) {
        byte[] imageData = iServiceCours.getCoursImageById(coursId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/displayVideo/{coursId}")
    public ResponseEntity<byte[]> displayVideo(@PathVariable Long coursId) {
        byte[] videoData = iServiceCours.getCoursVideoById(coursId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("video/mp4")); // Définir le type de contenu en tant que vidéo MP4

        return new ResponseEntity<>(videoData, headers, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCoursById(@PathVariable Long id) {
        Cours cours = iServiceCours.getCoursById(id);
        if (cours != null) {
            return new ResponseEntity<>(cours, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
