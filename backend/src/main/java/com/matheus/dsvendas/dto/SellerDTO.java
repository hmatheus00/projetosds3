package com.matheus.dsvendas.dto;

import com.matheus.dsvendas.entities.Seller;

public class SellerDTO {

	private Long id;
	private String name;
	
	public SellerDTO () {}
	
	public SellerDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public SellerDTO(Seller entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
