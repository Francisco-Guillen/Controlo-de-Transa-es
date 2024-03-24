package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogOperationsRepository extends CrudRepository <LogOperations,  Integer> {
	
	LogOperations findByNumReg(int NumReg);

}



