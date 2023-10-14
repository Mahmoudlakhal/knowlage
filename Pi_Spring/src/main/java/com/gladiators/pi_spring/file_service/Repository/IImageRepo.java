package com.gladiators.pi_spring.file_service.Repository;

import com.gladiators.pi_spring.Entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepo extends JpaRepository<Image,Integer> {

}
