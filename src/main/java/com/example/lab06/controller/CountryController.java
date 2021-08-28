package com.example.lab06.controller;

import com.example.lab06.dto.CountryDto;
import com.example.lab06.model.Country;
import com.example.lab06.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CountryController {

    private final CountryRepository repository;

    @Autowired
    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countries")
    public List<CountryDto> getAll() {
        return repository.findAll().stream()
                .map(CountryDto::toDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @PostMapping("/save")
    @Transactional
    public CountryDto save(@RequestBody Country country) {
        return CountryDto.toDto(repository.save(country));
    }


    @GetMapping("/find/start/{name}")
    public List<CountryDto> findByNameStartingWith(@PathVariable("name") String name) {
        return repository.findByNameStartingWith(name).stream()
                .map(CountryDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/update")
    @Transactional
    public void updateCountryName(
            @RequestParam("codeName") String codeName,
            @RequestParam("name") String newCountryName) {
        repository.updateCountryName(codeName, newCountryName);
    }

    @GetMapping("/find/code/{code}")
    public CountryDto findByCodeName(@PathVariable("code") String codeName) {
        return CountryDto.toDto(repository.findByCodeName(codeName));
    }

}
