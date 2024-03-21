package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.Tourist;

import jakarta.transaction.Transactional;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> 
{
	 @Query(" FROM Tourist WHERE name=:name1")
     public  List<Tourist> findByName(String name1);
	 
	 @Query("DELETE FROM Tourist WHERE budget>=:start AND budget<=:end")
	 @Modifying
	 @Transactional
	 public int removeToristByBudgetRange(Double start, Double end);
}
