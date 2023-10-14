package com.gladiators.pi_spring.file_service.Repository;

import com.gladiators.pi_spring.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepo extends JpaRepository<Video,Integer> {
}
