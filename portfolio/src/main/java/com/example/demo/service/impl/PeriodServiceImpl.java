package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PeriodRepository;
import com.example.demo.entity.Period;
import com.example.demo.service.PeriodService;

@Service
public class PeriodServiceImpl implements PeriodService {
	
	private PeriodRepository periodRepository;
	
	@Autowired
	public PeriodServiceImpl(PeriodRepository periodRepository) {
		this.periodRepository = periodRepository;
	}

	@Override
	public List<Period> findAll() {
		return periodRepository.findAll();
	}

	@Override
	public Period findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Period thePeriod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
