package com.gladiators.pi_spring.file_service.file_IService;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IVideoService {
    public String saveVideo(MultipartFile file) throws IOException;

    public byte[] getVideo(int videoId) throws IOException;
}
