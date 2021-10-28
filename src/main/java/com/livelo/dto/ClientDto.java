package com.livelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    private Long id;
    private String name;
    private LocalDate birth;
    private int age;
    private char sex;
    private String city;

}
