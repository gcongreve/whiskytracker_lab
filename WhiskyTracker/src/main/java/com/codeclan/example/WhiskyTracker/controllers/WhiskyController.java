package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @RequestMapping("year/{year}")
    public List<Whisky> getWhiskyByYear(@PathVariable int year){
        return whiskyRepository.getWhiskyByYear(year);
    }

//    @RequestMapping("distilleries/{distillery}/year/{year}")
//    public List<Whisky> getWhiskyByDistilleryByYear(@PathVariable )

    @RequestMapping("region/{region}")
    public List<Whisky> getWhiskyByRegion(@PathVariable String region){
        return whiskyRepository.getWhiskyByRegion(region);
    }

}
