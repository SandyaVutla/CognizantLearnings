package com.cognizant.spring_learn3.service;

import com.cognizant.spring_learn3.model.Country;
import com.cognizant.spring_learn3.service.exception.CountryNotFoundException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) throws CountryNotFoundException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        List<Country> countryList = (List<Country>) context.getBean("countryList");

        return countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country Not found"));
    }
}
