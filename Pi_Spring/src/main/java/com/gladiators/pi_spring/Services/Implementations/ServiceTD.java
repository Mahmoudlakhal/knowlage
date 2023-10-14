package com.gladiators.pi_spring.Services.Implementations;

import com.gladiators.pi_spring.Entities.TD;
import com.gladiators.pi_spring.Repositories.TdRepository;
import com.gladiators.pi_spring.Services.Interfaces.IServiceTd;
import com.gladiators.pi_spring.file_service.file_Services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServiceTD implements IServiceTd {
    @Autowired
    TdRepository tdRepository;

    @Override
    public TD AddTd(TD td){
        tdRepository.save(td);
        return td;
    }

    @Override
    public List<TD> retrieveAllTD(){
        List<TD> tdList = tdRepository.findAll();
        return tdList;
    }
}
