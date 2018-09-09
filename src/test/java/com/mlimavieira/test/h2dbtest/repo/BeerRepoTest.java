package com.mlimavieira.test.h2dbtest.repo;


import com.mlimavieira.test.h2dbtest.model.Beer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase= Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:sql/schema-h2.sql", "classpath:sql/data-h2.sql"}),
        @Sql(executionPhase= Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/clean-db.sql")
})
public class BeerRepoTest {

    @Autowired
    private BeerRepository beerRepository;

    @Test
    public void findAllTest() {

        List<Beer> list = (List<Beer>) beerRepository.findAll();

        assertThat(list, not(emptyCollectionOf(Beer.class)));


        assertThat(list, hasItem(hasProperty("name", is("Heineken"))));

    }

    @Test
    public void saveTest() {
        Beer beer = new Beer(UUID.randomUUID().toString(), "test");
        beer = beerRepository.save(beer);


        assertThat(beer, not(nullValue()));
        assertThat(beer.getId(), not(nullValue()));
    }

}
