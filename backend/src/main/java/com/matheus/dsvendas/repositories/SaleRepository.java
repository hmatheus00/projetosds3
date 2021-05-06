package com.matheus.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.dsvendas.dto.SaleSucessDTO;
import com.matheus.dsvendas.dto.SaleSumDTO;
import com.matheus.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.matheus.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.matheus.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> saleGroupBySeller();
}
