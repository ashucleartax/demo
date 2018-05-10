package com.example.demo.service;

import com.example.demo.entity.Demo;
import com.example.demo.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ashutoshpandey on 11/05/18.
 */
@Service
@Slf4j
public class DemoService {

    @Autowired
    DemoRepository demoRepository;

    public Iterable<Demo> findAll(){
        return demoRepository.findAll();
    }

    public Demo find(String externalId){
        return demoRepository.findByExternalId(externalId);
    }

    public Demo create(Demo Demo){
        log.info("Saving new Demo");
        return demoRepository.save(Demo);
    }

    public Demo update(String externalId, Demo demo){
        Demo currentDemo = demoRepository.findByExternalId(externalId);
        //Updation Logic
        return demoRepository.save(currentDemo);
    }

    public void delete(String externalId){
        Demo Demo = demoRepository.findByExternalId(externalId);
        demoRepository.delete(Demo);
    }
}
