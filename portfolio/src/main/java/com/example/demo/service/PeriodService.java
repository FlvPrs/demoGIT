package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Period;

public interface PeriodService {
	
	public List<Period> findAll();
	
	public Period findById(int theId);
	
	public void save(Period thePeriod);
	
	public void deleteById(int theId);

}
