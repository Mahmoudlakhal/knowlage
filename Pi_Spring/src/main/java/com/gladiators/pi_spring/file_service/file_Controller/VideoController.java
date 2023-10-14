package com.gladiators.pi_spring.file_service.file_Controller;


import com.gladiators.pi_spring.file_service.file_IService.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    IVideoService iVideoService;


    @PostMapping("/saveVideo")
    public ResponseEntity<?> saveVideo(@RequestParam("video") MultipartFile file) throws IOException {
        String message =iVideoService.saveVideo(file);
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }


    @GetMapping("/getVideo/{id}")
    public ResponseEntity<?> getImage(@PathVariable int id) throws IOException {
        byte[] video =iVideoService.getVideo(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("video/mp4")).
                body(video);

    }







}
