package com.wqs.app.service;

import java.time.LocalDate;
import java.util.List;

import com.wqs.app.dto.WaterRequest;
import com.wqs.app.entity.WaterReading;

public interface WaterService {

    WaterReading addReading(WaterRequest request);

    List<WaterReading> getAll();

    WaterReading getById(Long id);
    
    List<WaterReading> getByLocation(String location);
    
    List<WaterReading> getByDate(LocalDate date);

    WaterReading updateReading(Long id, WaterRequest request);

    String deleteById(Long id);
    

}