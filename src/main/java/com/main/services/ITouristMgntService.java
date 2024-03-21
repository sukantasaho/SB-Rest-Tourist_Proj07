package com.main.services;

import java.util.List;
import java.util.Optional;

import com.main.entity.Tourist;

public interface ITouristMgntService 
{
    public String registerTourist(Tourist tourist);
    public String registerAllTourist(List<Tourist> touristList);
    public List<Tourist> getAllTouristDetails();
    public Tourist getTouristById(Integer id);
    public String updateTourist(Tourist tourist);
    public List<Tourist> getTouristByName(String name);
    public String updateTouristBudgetById(Integer id, Double hikePercentage);
    public String removeTouristById(Integer id);
    public String removeTouristByBudgetRange(Double start, Double end);
}
