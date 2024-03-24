package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncomendaRepository extends CrudRepository <Encomenda,  Integer>{

	Encomenda findByEncId(int EncId);
		
}
