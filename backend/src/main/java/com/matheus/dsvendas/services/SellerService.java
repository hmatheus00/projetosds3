package com.matheus.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.dsvendas.dto.SellerDTO;
import com.matheus.dsvendas.entities.Seller;
import com.matheus.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = sellerRepository.findAll();
		return result.stream().map(res -> new SellerDTO(res)).collect(Collectors.toList());
	}
	
	public Seller findById(Long id){
		return sellerRepository.findById(id).orElseThrow();
	}
	
	
}
