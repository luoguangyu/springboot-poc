package com.ivan.boot.service;

import com.ivan.boot.domain.City;
import com.ivan.boot.repository.CitySearchCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 4/7/2016 2:30 PM
 */
@Component("cityService")
@Transactional
public class CityServiceImpl implements CityService
{
	@Autowired
	private CityRepository cityRepository;
	private final static Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

	@Override
	public Page<City> findCities(CitySearchCriteria criteria, Pageable pageable)
	{

		Assert.notNull(criteria, "Criteria must not be null");
		String name = criteria.getName();

		if (!StringUtils.hasLength(name))
		{
			return this.cityRepository.findAll(null);
		}

		String country = "";
		int splitPos = name.lastIndexOf(",");

		if (splitPos >= 0)
		{
			country = name.substring(splitPos + 1);
			name = name.substring(0, splitPos);
		}

		return this.cityRepository
				.findByNameContainingAndCountryContainingAllIgnoringCase(name.trim(), country.trim(), pageable);
	}

	@Override
	public List<City> findAllCities()
	{
		return cityRepository.findAll();
	}

	@Override
	public City getCity(String name, String country)
	{
		Assert.notNull(name, "Name must not be null");
		Assert.notNull(country, "Country must not be null");
		LOGGER.info("name=" + name + ",country=" + country);
		LOGGER.info("cityRepository="+cityRepository);
		return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
	}

	@Override
	public City save(City city)
	{
		return this.cityRepository.save(city);
	}
}
