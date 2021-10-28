package com.livelo.dto;

import com.livelo.model.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    private String name;
    private String state;

    public City converterToEntity(CityDto cityDto) {
        City city = new City();
        city.setName(cityDto.getName());
        city.setState(cityDto.getState());
        return city;
    }

    public CityDto converterToDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setName(city.getName());
        cityDto.setState(city.getState());
        return cityDto;
    }
}
