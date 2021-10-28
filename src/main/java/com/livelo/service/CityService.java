package com.livelo.service;

import com.livelo.dto.CityDto;
import com.livelo.model.City;
import com.livelo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City register(CityDto cityDto) {
        return cityRepository.save(cityDto.converterToEntity(cityDto));
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public List<City> findCityByName(String name) {
        return (List<City>) cityRepository.findByName(name);
    }

    public List<City> findStateByName(String state) {
        return (List<City>) cityRepository.findByState(state);
    }
}
