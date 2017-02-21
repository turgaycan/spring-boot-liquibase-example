package com.user.repository;


import com.user.domain.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by Turgay.Can on 2017-02-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CityRepositoryTest {

    @Autowired
    private CityRepository repository;

    @Before
    public void init() {
        for (long index = 1; index < 40; index++) {
            City city = new City("trabzon" + index, "türkiye", "karadeniz", String.valueOf(index));
            repository.save(city);
        }
    }

    @Test
    public void findsFirstPageOfCities() {
        Page<City> cities = repository.findAll(new PageRequest(0, 10));
        assertThat(cities.getTotalElements()).isGreaterThan(20L);
    }

    @Test
    public void findPersistOne() {
        City city = new City("trabzon", "türkiye");
        city.setState("Karadeniz");
        city.setMap("-27.470933, 153.023502");

        final City persistOne = repository.save(city);

        Assert.assertNotNull(persistOne);

        final City one = repository.findOne(persistOne.getId());

        assertEquals("trabzon", one.getName());
        assertEquals("türkiye", one.getCountry());
    }
}