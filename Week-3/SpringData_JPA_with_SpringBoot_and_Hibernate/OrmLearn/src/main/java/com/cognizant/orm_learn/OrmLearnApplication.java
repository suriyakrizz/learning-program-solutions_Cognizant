package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAllCountries();
        getCountryTest();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    private void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        for (Country country : countries) {
            LOGGER.debug("Country: {}", country);
        }
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    private void getCountryTest() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
            LOGGER.info("Country name is valid.");
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("End");
    }

    private void testAddCountry() {
        LOGGER.info("Start");
        Country newCountry = new Country("JP", "Japan");
        countryService.addCountry(newCountry);

        try {
            Country saved = countryService.findCountryByCode("JP");
            LOGGER.debug("Added: {}", saved);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Not found after adding: " + e.getMessage());
        }
        LOGGER.info("End");
    }

    private void testUpdateCountry() {
        LOGGER.info("Start");
        try {
            countryService.updateCountry("JP", "Nippon");
            Country updated = countryService.findCountryByCode("JP");
            LOGGER.debug("Updated: {}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("End");
    }

    private void testDeleteCountry() {
        LOGGER.info("Start");
        try {
            countryService.deleteCountry("JP");
            countryService.findCountryByCode("JP");  // Should throw
        } catch (CountryNotFoundException e) {
            LOGGER.warn("Expected: " + e.getMessage());
        }
        LOGGER.info("End");
    }
}
