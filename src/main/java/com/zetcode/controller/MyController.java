package com.zetcode.controller;

import com.zetcode.bean.City;
import com.zetcode.service.ICityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebMethod;

@Controller
public class MyController {

    @Autowired
    ICityService cityService;

    @RequestMapping("/showCities")
    public String findCities(Model model) {

        List<City> cities = (List<City>) cityService.findAll();

        model.addAttribute("cities", cities);

        return "showCities";
    }

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public ResponseEntity<City> saveCity(@RequestBody City city) {

        City saved = cityService.create(city);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}