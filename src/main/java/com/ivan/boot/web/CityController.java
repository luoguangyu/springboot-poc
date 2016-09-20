package com.ivan.boot.web;

import com.ivan.boot.domain.City;
import com.ivan.boot.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 4/7/2016 3:19 PM
 */
@RestController
public class CityController
{
	@Autowired
	private CityService cityService;
	private final static Logger LOGGER = LoggerFactory.getLogger(CityController.class);

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	public City getCity(@RequestParam(value = "name", defaultValue = "London") String name,
			@RequestParam(value = "country", defaultValue = "UK") String country)
	{
		LOGGER.info("getting city by name:{} and country{}", new Object[] { name, country });
		City city = cityService.getCity(name, country);
		LOGGER.info("return city:" + city);
		return city;
	}

	@RequestMapping(value = "/cities", method = RequestMethod.GET)

	public List<City> getCities()
	{
		List<City> cities = cityService.findAllCities();

		LOGGER.info("return city:" + cities);

		return cities;
	}

	@RequestMapping(value = "/city", method = RequestMethod.POST, produces = "application/json")

	public ResponseEntity saveCity(@RequestBody City city)
	{

		LOGGER.info("saving city" + city);
		cityService.save(city);
		return new ResponseEntity(HttpStatus.OK);
	}
}
