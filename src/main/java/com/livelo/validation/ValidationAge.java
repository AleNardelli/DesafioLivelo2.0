package com.livelo.validation;


import com.livelo.exception.DateException;
import com.livelo.model.Client;
import lombok.var;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ValidationAge {

    public void validate(Client client){

        if(client.getBirth().isAfter(LocalDate.now())){

            throw new DateException("DATE INVALID!");

        }

        if(client.getBirth().isEqual(LocalDate.now())){

            throw new DateException("DATE INVALID!");

        }
        LocalDate birthDate = client.getBirth();
        var age = getAgeForBirthDate(birthDate);
        client.setAge(age);
    }

    private int getAgeForBirthDate(LocalDate birthDate) {
        var age = Period.between(birthDate, LocalDate.now()).getYears();
        return age;
    }



}

