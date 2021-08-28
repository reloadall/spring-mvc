package com.example.lab06.repository;

import com.example.lab06.model.Country;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    @Override
    List<Country> findAll();

    List<Country> findByNameStartingWith(String name);

    @Modifying
    @Query(value = "update Country c set c.name = :name where c.codeName = :codeName")
    void updateCountryName(
            @Param("codeName") String codeName,
            @Param("name") String newCountryName);

    Country findByCodeName(String codeName);

    Country findByName(String name);
}
