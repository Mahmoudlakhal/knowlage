package com.gladiators.pi_spring.file_service.file_IService;

import com.gladiators.pi_spring.Entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {

    public Image saveImage(MultipartFile image) throws IOException;
    public byte[] getImage(int imageId) throws IOException;


}
