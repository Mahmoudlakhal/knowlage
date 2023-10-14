package com.gladiators.pi_spring.Controllers;


import com.gladiators.pi_spring.Entities.Categorie;
import com.gladiators.pi_spring.Entities.Prix;
import com.gladiators.pi_spring.Entities.TD;
import com.gladiators.pi_spring.Repositories.TdRepository;
import com.gladiators.pi_spring.Services.Interfaces.IServiceTd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/TD")
public class TdController {

    @Autowired
    IServiceTd iServiceTd;

    @PostMapping("/addTD")
    public TD addTd(@RequestParam("photo") MultipartFile photo , @PathParam("title") String title, @PathParam("subject") String subject, @PathParam("content") String content, @PathParam("prix") Prix prix, @PathParam("categorie") Categorie categorie,@RequestParam("file") MultipartFile file) throws IOException {
        TD  td =new TD();
        td.setPhoto(photo.getBytes());
        td.setTitle(title);
        td.setSubject(subject);
        td.setContent(content);
        td.setPrix(prix);
        td.setCategorie(categorie);
        td.setFile(file.getBytes());

        return iServiceTd.AddTd(td);
    }

    @GetMapping("/display")
    public List<TD> retrieveAll(){
        return iServiceTd.retrieveAllTD();
    }
}
