package com.mlimavieira.test.h2dbtest.controller;

import com.mlimavieira.test.h2dbtest.model.Beer;
import com.mlimavieira.test.h2dbtest.repo.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/beer")
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @GetMapping
    public List<Beer> list() {

        return (List<Beer>) beerRepository.findAll();
    }

    @PostMapping
    public Beer save(@RequestBody Beer beer) {

        return beerRepository.save(beer);
    }

    @DeleteMapping("/{id}")
    public void save(@PathVariable("id") Integer id) {

        beerRepository.deleteById(id);
    }
}
