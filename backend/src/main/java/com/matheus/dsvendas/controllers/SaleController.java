package com.matheus.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.dsvendas.dto.SaleDTO;
import com.matheus.dsvendas.dto.SaleSucessDTO;
import com.matheus.dsvendas.dto.SaleSumDTO;
import com.matheus.dsvendas.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> result = service.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/sum-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountByGroupSeller(){
		List<SaleSumDTO> result = service.amountGroupedBySeller();
		return ResponseEntity.ok(result);
	}
	@GetMapping(value = "/sale-by-seller")
	public ResponseEntity<List<SaleSucessDTO>> saleByGroupSeller(){
		List<SaleSucessDTO> result = service.saleGroupBySeller();
		return ResponseEntity.ok(result);
	}
}
