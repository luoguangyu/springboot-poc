package com.ivan.boot.service;

import com.ivan.boot.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 4/7/2016 2:25 PM
 */
interface CityRepository extends Repository<City, Long>
{

	Page<City> findAll(Pageable pageable);

	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
			String country, Pageable pageable);

	City findByNameAndCountryAllIgnoringCase(String name, String country);
	List<City> findAll();

	City save(City city);
}