package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @RequestMapping("region/{region}")
    public List<Distillery> findDistilleriesByRegion (@PathVariable String region) {
        return distilleryRepository.getDistilleryByRegion(region);
    }

    @RequestMapping("whiskies/{age}")
    public List<Distillery> findDistilleriesByWhiskyAge (@PathVariable int age) {
        return distilleryRepository.getDistilleryByAgeOfWhisky(age);
    }

}
