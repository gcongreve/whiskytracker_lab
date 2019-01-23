package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface DistilleryRepositoryCustom {

    public List<Distillery> getDistilleryByRegion(String distillery);

    List<Distillery> getDistilleryByAgeOfWhisky(int age);

}
