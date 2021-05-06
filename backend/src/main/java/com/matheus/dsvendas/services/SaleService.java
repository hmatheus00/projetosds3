package com.matheus.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.dsvendas.dto.SaleDTO;
import com.matheus.dsvendas.entities.Sale;
import com.matheus.dsvendas.repositories.SaleRepository;
import com.matheus.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(res -> new SaleDTO(res));
	}
	
	public Sale findById(Long id){
		return repository.findById(id).orElseThrow();
	}
	
	
}
