package com.livelo.controller;

import com.livelo.dto.CityDto;
import com.livelo.model.City;
import com.livelo.repository.CityRepository;
import com.livelo.service.CityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityService cityService;

    @PostMapping("/register")
    @ApiOperation(value = "Register City")
    public City city(@RequestBody CityDto cityDto) {
        return cityService.register(cityDto);
    }

    @GetMapping("/city")
    @ApiOperation(value = "Complete City List")
    public List<City> listAll() {
        return cityService.findAll();
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "Find City By Name")
    public List<City> findCityByName(@PathVariable String name) {
        return cityService.findCityByName(name);
    }

    @GetMapping("listState/{state}")
    @ApiOperation(value = "Find State By Name")
    public List<City> findStateByName(@PathVariable String state) {
        return cityService.findStateByName(state);
    }
}
