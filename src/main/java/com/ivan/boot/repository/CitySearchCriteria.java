package com.ivan.boot.repository;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * Created by Ivan.Luo
 * Date: 4/7/2016 2:29 PM
 */
public class CitySearchCriteria implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String name;

	public CitySearchCriteria() {
	}

	public CitySearchCriteria(String name) {
		Assert.notNull(name, "Name must not be null");
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
