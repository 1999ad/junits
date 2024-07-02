package com.example.springbootPractice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootPractice.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
