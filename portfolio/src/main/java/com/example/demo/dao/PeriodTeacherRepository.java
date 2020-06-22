package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.PeriodTeacher;

public interface PeriodTeacherRepository extends JpaRepository<PeriodTeacher, Integer> {
	
	@Query("SELECT a FROM #{#entityName} a WHERE period_id = ?1 AND available = true")
	List<PeriodTeacher> findByPeriodId(int period_id);
	
	@Query("SELECT a FROM #{#entityName} a WHERE teacher_id = ?1 AND period_id = ?2")
	PeriodTeacher findByTeacherIdAndPeriodId(int teacherId, int periodId);
	
}
