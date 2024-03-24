package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncLinhaRepository extends JpaRepository <EncLinha,  EncLinhaId> {
	
	Iterable<EncLinha> findByEncomenda(Encomenda encomenda);
	
	//Iterable<EncLinha> findByEncLinhaid(EncLinhaId encLinhaId);
	
	EncLinha findByEncLinhaid(EncLinhaId encLinhaId);
}
	
	
	
	


