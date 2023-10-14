package com.gladiators.pi_spring.file_service.file_Services;


import com.gladiators.pi_spring.Entities.Image;
import com.gladiators.pi_spring.file_service.Repository.IImageRepo;
import com.gladiators.pi_spring.file_service.file_IService.IImageService;
import com.gladiators.pi_spring.file_service.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class ImageService implements IImageService {

    @Autowired
    IImageRepo iImageRepo;


    @Override
    public Image saveImage(MultipartFile file) throws IOException {
       Image image= iImageRepo.save(Image.builder().imageData(FileUtils.compressFile(file.getBytes())).build());
    if(image !=null){
        return image;}
    else {
        return null;
    }
    }

    @Override
    public byte[] getImage(int imageId) throws IOException {
        Image image=iImageRepo.findById(imageId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"The image doesn't exits"));
        return   FileUtils.decompressFile(image.getImageData());
    }




}
