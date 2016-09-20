package com.ivan.boot.service;

import com.ivan.boot.domain.City;
import com.ivan.boot.repository.CitySearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 4/7/2016 2:27 PM
 */
public interface CityService
{

	Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);
	List<City> findAllCities();
	City getCity(String name, String country);
	City save(City city);
}
