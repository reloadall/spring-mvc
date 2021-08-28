package com.example.lab06.dto;

import com.example.lab06.model.Country;

public class CountryDto {

    private String name;
    private String codeName;

    public CountryDto(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    public CountryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public static CountryDto toDto(Country country){
        return new CountryDto(country.getName(), country.getCodeName());
    }
}
