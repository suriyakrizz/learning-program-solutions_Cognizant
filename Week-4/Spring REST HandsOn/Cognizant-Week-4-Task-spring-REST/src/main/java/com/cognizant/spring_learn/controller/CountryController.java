package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("Start: getCountryIndia");
        Country country = (Country) context.getBean("in");
        LOGGER.info("End: getCountryIndia");
        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("Start: getAllCountries");
        List<Country> countryList = (List<Country>) context.getBean("countryList");
        LOGGER.info("End: getAllCountries");
        return countryList;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("Start: getCountry with code={}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("End: getCountry");
        return country;
    }
}
