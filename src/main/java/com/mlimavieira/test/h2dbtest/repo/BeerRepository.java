package com.mlimavieira.test.h2dbtest.repo;

import com.mlimavieira.test.h2dbtest.model.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Integer> {

}
