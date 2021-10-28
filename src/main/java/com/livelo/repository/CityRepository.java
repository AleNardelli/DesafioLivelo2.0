package com.livelo.repository;

import com.livelo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByName(String name);

    List<City> findByState(String state);
}
