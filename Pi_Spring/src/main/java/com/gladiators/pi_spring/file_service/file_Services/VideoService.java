package com.gladiators.pi_spring.file_service.file_Services;


import com.gladiators.pi_spring.Entities.Video;
import com.gladiators.pi_spring.file_service.Repository.IVideoRepo;
import com.gladiators.pi_spring.file_service.file_IService.IVideoService;
import com.gladiators.pi_spring.file_service.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class VideoService implements IVideoService {
    @Autowired
    IVideoRepo iVideoRepo;

    @Override
    public String saveVideo(MultipartFile file) throws IOException {
        Video video= iVideoRepo.save(Video.builder().videoData(FileUtils.compressFile(file.getBytes())).build());
        if(video !=null){
            return "video uploaded successfully";}
        else {
            return null;
        }
    }

    @Override
    public byte[] getVideo(int videoId) throws IOException {
        Video video=iVideoRepo.findById(videoId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"The video doesn't exits"));
        return FileUtils.decompressFile(video.getVideoData());
    }

}
